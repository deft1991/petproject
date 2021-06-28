package com.example.application.views.dictionary;

import com.example.application.data.dataprovider.DeftCrudServiceDataProvider;
import com.example.application.data.model.UnitType;
import com.example.application.data.service.UnitTypeService;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.storedobject.vaadin.LongField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * @author Sergey Golitsyn
 * created on 03.12.2020
 */

@CssImport("./styles/views/helloworld/hello-world-view.css")
@Route(value = "unit_type", layout = MainView.class)
@PageTitle("Unit Type")
public class UnitTypeView extends Div {

    private Grid<UnitType> grid = new Grid<>(UnitType.class, false);

    private LongField id;
    private TextField alias;

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private BeanValidationBinder<UnitType> binder;

    private UnitType unitType;

    public UnitTypeView(@Autowired UnitTypeService unitTypeService) {
        setId("hello-world-view");
        // Create UI
        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);

        // Configure Grid
        grid.addColumn("id").setAutoWidth(true);
        grid.addColumn("alias").setAutoWidth(true);

        grid.setItems(new DeftCrudServiceDataProvider<>(unitTypeService));
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.setHeightFull();

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                Optional<UnitType> personFromBackend = unitTypeService.get(event.getValue().getId());
                // when a row is selected but the data is no longer available, refresh grid
                if (personFromBackend.isPresent()) {
                    populateForm(personFromBackend.get());
                } else {
                    refreshGrid();
                }
            } else {
                clearForm();
            }
        });

        // Configure Form
        binder = new BeanValidationBinder<>(UnitType.class);

        // Bind fields. This where you'd define e.g. validation rules

        binder.bindInstanceFields(this);

        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {
            try {
                if (this.unitType == null) {
                    this.unitType = new UnitType();
                }
                binder.writeBean(this.unitType);
                unitTypeService.update(this.unitType);
                clearForm();
                refreshGrid();
                Notification.show("UnitType details stored.");
            } catch (ValidationException validationException) {
                Notification.show("An exception happened while trying to store the UnitType details.");
            }
        });

    }

    private void createEditorLayout(SplitLayout splitLayout) {
        Div editorLayoutDiv = new Div();
        editorLayoutDiv.setId("editor-layout");

        Div editorDiv = new Div();
        editorDiv.setId("editor");
        editorLayoutDiv.add(editorDiv);

        FormLayout formLayout = new FormLayout();
        id = new LongField("ID");
        alias = new TextField("Alias");
        AbstractField<?, ?>[] fields = new AbstractField<?, ?>[]{id, alias};

        for (AbstractField<?, ?> field : fields) {
            ((HasStyle) field).addClassName("full-width");
        }
        formLayout.add(fields);
        editorDiv.add(formLayout);
        createButtonLayout(editorLayoutDiv);

        splitLayout.addToSecondary(editorLayoutDiv);
    }

    private void createButtonLayout(Div editorLayoutDiv) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setId("button-layout");
        buttonLayout.setWidthFull();
        buttonLayout.setSpacing(true);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save, cancel);
        editorLayoutDiv.add(buttonLayout);
    }

    private void createGridLayout(SplitLayout splitLayout) {
        Div wrapper = new Div();
        wrapper.setId("grid-wrapper");
        wrapper.setWidthFull();
        splitLayout.addToPrimary(wrapper);
        wrapper.add(grid);
    }

    private void refreshGrid() {
        grid.select(null);
        grid.getDataProvider().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(UnitType value) {
        this.unitType = value;
        binder.readBean(this.unitType);
    }
}
