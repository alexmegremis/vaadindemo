package com.alexmegremis.vaadindemo;

import com.alexmegremis.vaadindemo.persistence.*;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private final PermissionsRepo permissionsRepo;
    private final PrincipalsRepo  principalsRepo;

    private final Grid<ViewPermissionsEntity> permissionsGrid;
    private final Grid<ViewPrincipalEntity>   principalsGrid;

    public MainView(final PermissionsRepo permissionsRepo, final PrincipalsRepo principalsRepo) {
        this.permissionsRepo = permissionsRepo;
        this.principalsRepo = principalsRepo;
        this.permissionsGrid = new Grid<>(ViewPermissionsEntity.class);
        this.principalsGrid = new Grid<>(ViewPrincipalEntity.class);
        permissionsGrid.setItems(permissionsRepo.findAll());
        principalsGrid.setItems(principalsRepo.findAll());

        permissionsGrid.appendHeaderRow();
        permissionsGrid.appendFooterRow();

        permissionsGrid.setPageSize(5);

        TextField filterNameLast = new TextField();
        filterNameLast.setPlaceholder("Filter by last name");
        filterNameLast.setValueChangeMode(ValueChangeMode.EAGER);
        filterNameLast.addValueChangeListener(e -> permissionsGrid.setItems(permissionsRepo.findByNameLastStartsWithIgnoreCase(e.getValue())));

        TextField filterNameFirst = new TextField();
        filterNameFirst.setPlaceholder("Filter by first name");
        filterNameFirst.setValueChangeMode(ValueChangeMode.EAGER);
        filterNameFirst.addValueChangeListener(e -> permissionsGrid.setItems(permissionsRepo.findByNameFirstStartsWithIgnoreCase(e.getValue())));

        add(permissionsGrid, principalsGrid, filterNameLast, filterNameFirst);
    }

//    public MainView() {
//        add(new Button("Click me", e -> Notification.show("Hello, Spring+Vaadin user!")));
//    }
}
