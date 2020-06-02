package com.alexmegremis.vaadindemo;

import com.alexmegremis.vaadindemo.persistence.*;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.*;

@Theme ("valo")
@SpringUI
@SpringViewDisplay
public class MainView extends UI implements ViewDisplay {

    private final PermissionsRepo permissionsRepo;
    private final PrincipalsRepo  principalsRepo;

    final Grid<ViewPermissionsEntity> permissionsGrid = new Grid<>(ViewPermissionsEntity.class);
    final Grid<ViewPrincipalEntity>   principalsGrid  = new Grid<>(ViewPrincipalEntity.class);

    private Panel springViewDisplay;

    public MainView(final PermissionsRepo permissionsRepo, final PrincipalsRepo principalsRepo) {
        this.permissionsRepo = permissionsRepo;
        this.principalsRepo = principalsRepo;
    }

    @Override
    protected void init(final VaadinRequest vaadinRequest) {

        permissionsGrid.setWidth(100f, Unit.PERCENTAGE);
        principalsGrid.setWidth(100f, Unit.PERCENTAGE);

        permissionsGrid.setColumns("nameFirst", "nameLast", "principal", "repo", "permissionBits");

        permissionsGrid.setItems(permissionsRepo.findAll());
        principalsGrid.setItems(principalsRepo.findAll());

        TextField filterNameLast = new TextField();
        filterNameLast.setPlaceholder("Filter by last name");
        filterNameLast.setValueChangeMode(ValueChangeMode.EAGER);
        filterNameLast.addValueChangeListener(e -> permissionsGrid.setItems(permissionsRepo.findByNameLastStartsWithIgnoreCase(e.getValue())));

        TextField filterNameFirst = new TextField();
        filterNameFirst.setPlaceholder("Filter by first name");
        filterNameFirst.setValueChangeMode(ValueChangeMode.EAGER);
        filterNameFirst.addValueChangeListener(e -> permissionsGrid.setItems(permissionsRepo.findByNameFirstStartsWithIgnoreCase(e.getValue())));

        springViewDisplay = new Panel();
        springViewDisplay.setSizeFull();

        VerticalLayout layout = new VerticalLayout(filterNameLast, filterNameFirst, permissionsGrid, principalsGrid, springViewDisplay);
        layout.setSizeFull();
        layout.setWidth(100f, Unit.PERCENTAGE);

        layout.setExpandRatio(springViewDisplay, 1.0f);

        layout.setMargin(true);
        layout.setSpacing(true);

        setContent(layout);
    }

    @Override
    public void showView(final View view) {
        springViewDisplay.setContent((Component) view);
    }
}
