package com.alexmegremis.vaadindemo;

import com.alexmegremis.vaadindemo.persistence.*;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.components.grid.ItemClickListener;

import java.util.Map;
import java.util.stream.Collectors;

//@Theme ("valo")
@SpringUI
public class MainView extends UI {

    private final ViewPermissionsService service;

    public MainView(final ViewPermissionsService service) {
        this.service = service;
    }

    @Override
    protected void init(final VaadinRequest vaadinRequest) {

        Grid<DispositionDTO> permissionsGrid = new Grid<>(DispositionDTO.class);

        permissionsGrid.setSizeFull();

        permissionsGrid.setColumns("nameFirst", "nameLast", "principal", "repo", "permissionBits", "disposition");
        permissionsGrid.getColumn("disposition").setEditorComponent(new TextField("foo")).setEditable(true);
        permissionsGrid.addComponentColumn(DispositionDTO -> {
            Button button = new Button("Click me!");
            button.addClickListener(click ->
                                            Notification.show("Clicked: " + DispositionDTO.getNameLast().toString()));
            return button;
        });
//        permissionsGrid.addItemClickListener((ItemClickListener<DispositionDTO>) event -> permissionsGrid.getEditor().setEnabled(event.getColumn().getCaption().equals("Disposition")));


        permissionsGrid.setDataProvider((sortOrders, offset, limit) -> {
            Map<String, Boolean> sortOrder = sortOrders.stream().collect(Collectors.toMap(sort -> sort.getSorted(), sort -> sort.getDirection() == SortDirection.ASCENDING));

            return service.findAll(offset, limit, sortOrder).stream();
        }, () -> service.count());

        VerticalLayout layout = new VerticalLayout(permissionsGrid);
        layout.setSizeFull();
        setContent(layout);
    }
}
