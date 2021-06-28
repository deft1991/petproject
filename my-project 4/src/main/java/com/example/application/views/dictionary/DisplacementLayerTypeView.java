package com.example.application.views.dictionary;

import com.example.application.data.dataprovider.DeftCrudServiceDataProvider;
import com.example.application.data.model.DisplacementLayerType;
import com.example.application.data.service.DisplacementLayerTypeService;
import com.example.application.views.main.MainView;
import com.storedobject.vaadin.LongField;
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
@Route(value = "displacement_layer_type", layout = MainView.class)
@PageTitle("Displacement Layer")
public class DisplacementLayerTypeView extends Div {
    private Grid<DisplacementLayerType> grid = new Grid<>(DisplacementLayerType.class, false);

    private LongField id;
    private TextField alias;

    private Button save = new Button("Save");
    private Button cancel = new Button("Cancel");

    private BeanValidationBinder<DisplacementLayerType> binder;

    private DisplacementLayerType DisplacementLayer;

    public DisplacementLayerTypeView(@Autowired DisplacementLayerTypeService displacementLayerService) {
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

        grid.setItems(new DeftCrudServiceDataProvider<>(displacementLayerService));
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.setHeightFull();

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                Optional<DisplacementLayerType> personFromBackend = displacementLayerService.get(event.getValue().getId());
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
        binder = new BeanValidationBinder<>(DisplacementLayerType.class);

        // Bind fields. This where you'd define e.g. validation rules

        binder.bindInstanceFields(this);

        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {
            try {
                if (this.DisplacementLayer == null) {
                    this.DisplacementLayer = new DisplacementLayerType();
                }
                binder.writeBean(this.DisplacementLayer);
                displacementLayerService.update(this.DisplacementLayer);
                clearForm();
                refreshGrid();
                Notification.show("DisplacementLayer details stored.");
            } catch (ValidationException validationException) {
                Notification.show("An exception happened while trying to store the DisplacementLayer details.");
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
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
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

    private void populateForm(DisplacementLayerType value) {
        this.DisplacementLayer = value;
        binder.readBean(this.DisplacementLayer);
    }
}
