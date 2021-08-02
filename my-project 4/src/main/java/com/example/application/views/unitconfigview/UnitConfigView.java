package com.example.application.views.unitconfigview;

import com.example.application.data.dataprovider.DeftCrudServiceDataProvider;
import com.example.application.data.model.DisplacementLayerType;
import com.example.application.data.model.Unit;
import com.example.application.data.model.UnitType;
import com.example.application.data.service.DisplacementLayerTypeService;
import com.example.application.data.service.UnitService;
import com.example.application.data.service.UnitTypeService;
import com.example.application.views.main.MainView;
import com.storedobject.vaadin.LongField;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.gatanaso.MultiselectComboBox;

import java.util.Optional;
import java.util.stream.Collectors;


/**
 * COLUMNS SHOULD NAMED AS FIELDS IN ENTITY, LIKE displacementLayerTypes SAME NAME IN ENTITY
 */
@Route(value = "unitconfig", layout = MainView.class)
@PageTitle("Unit Config")
@CssImport("./styles/views/helloworld/hello-world-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class UnitConfigView extends Div {

    private Grid<Unit> grid = new Grid<>(Unit.class, false);

    private LongField id;
    private TextField name;
    private TextField description;
    private IntegerField cost;
    private IntegerField count;
    private IntegerField addCapacity;
    private IntegerField unitHealth;
    private IntegerField unitsInGroup;
    private ComboBox<UnitType> unitType;
    private MultiselectComboBox<DisplacementLayerType> displacementLayerTypes;

    private IntegerField speed;
    private IntegerField minRange;
    private IntegerField range;
    private IntegerField damage;
    private IntegerField dps;
    private IntegerField fogOfWarRange;
    private Checkbox canAttackOnMove;
    private IntegerField unitFirstFireCooldown;


//    private Checkbox important;

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private BeanValidationBinder<Unit> binder;

    private Unit unit;

    private final UnitTypeService unitTypeService;
    private final DisplacementLayerTypeService displacementLayerTypeService;

    public UnitConfigView(@Autowired UnitService unitService
            , @Autowired UnitTypeService unitTypeService
            , @Autowired DisplacementLayerTypeService displacementLayerTypeService
    ) {
        this.unitTypeService = unitTypeService;
        this.displacementLayerTypeService = displacementLayerTypeService;

        setId("hello-world-view");
        // Create UI
        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);

        // Configure Grid
        grid.addColumn(Unit::getId).setHeader("ID").setAutoWidth(true);
        grid.addColumn(Unit::getName).setHeader("Название").setAutoWidth(true);
        grid.addColumn(Unit::getDescription).setHeader("Описание").setAutoWidth(true);
        grid.addColumn(Unit::getCost).setHeader("Стоимость производства").setAutoWidth(true);
        grid.addColumn("count").setHeader("Количество").setAutoWidth(true);

        grid.addColumn("addCapacity").setHeader("Add Capacity").setAutoWidth(true);
        grid.addColumn("unitHealth").setHeader("Unit Health").setAutoWidth(true);
        grid.addColumn("unitsInGroup").setHeader("Units in Group").setAutoWidth(true);

        grid.addColumn(unit -> unit.getUnitType() == null ? "" : unit.getUnitType().getAlias())
                .setHeader("Unit Type").setAutoWidth(true);

        grid.addComponentColumn(unit -> {
            MultiselectComboBox<String> selectRoles = new MultiselectComboBox<>();
            selectRoles.setItems(unit.getDisplacementLayerTypes().stream().map(DisplacementLayerType::getAlias).collect(Collectors.toList()));
            selectRoles.select(unit.getDisplacementLayerTypes().stream().map(DisplacementLayerType::getAlias).collect(Collectors.toList()));
            selectRoles.setReadOnly(true);
            return selectRoles;
        }).setHeader("Слой перемещения").setAutoWidth(true);

        grid.addColumn("speed").setHeader("Unit speed").setAutoWidth(true);
        grid.addColumn("minRange").setHeader("Unit minRange").setAutoWidth(true);
        grid.addColumn("range").setHeader("Unit range").setAutoWidth(true);
        grid.addColumn("damage").setHeader("Unit damage").setAutoWidth(true);
        grid.addColumn("dps").setHeader("Unit dps").setAutoWidth(true);
        grid.addColumn("fogOfWarRange").setHeader("Unit fogOfWarRange").setAutoWidth(true);

        TemplateRenderer<Unit> importantRenderer = TemplateRenderer.<Unit>of(
                "<iron-icon hidden='[[!item.canAttackOnMove]]' icon='vaadin:check' style='width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: var(--lumo-primary-text-color);'></iron-icon><iron-icon hidden='[[item.canAttackOnMove]]' icon='vaadin:minus' style='width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: var(--lumo-disabled-text-color);'></iron-icon>")
                .withProperty("canAttackOnMove", Unit::isCanAttackOnMove);
        grid.addColumn(importantRenderer).setHeader("Unit Can Attack On Move").setAutoWidth(true);
        grid.addColumn("unitFirstFireCooldown").setHeader("Unit First Fire Cooldown").setAutoWidth(true);

        grid.setItems(new DeftCrudServiceDataProvider<>(unitService));
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.setHeightFull();

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                Optional<Unit> personFromBackend = unitService.get(event.getValue().getId());
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
        binder = new BeanValidationBinder<>(Unit.class);

        // Bind fields. This where you'd define e.g. validation rules

        binder.bindInstanceFields(this);


        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {
            try {
                if (this.unit == null) {
                    this.unit = new Unit();
                }
                binder.writeBean(this.unit);
                unitService.update(this.unit);
                clearForm();
                refreshGrid();
                Notification.show("Unit details stored.");
            } catch (ValidationException validationException) {
                Notification.show("An exception happened while trying to store the Unit details.");
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
        name = new TextField("Название юнита ");
        description = new TextField("Описание");
        cost = new IntegerField("Стоимость производства");
        count = new IntegerField("Количество");

        addCapacity = new IntegerField("Add Capacity");
        unitHealth = new IntegerField("Unit Health");
        unitsInGroup = new IntegerField("Units in Group");

        unitType = new ComboBox<>("Тип Юнита");
        unitType.setItems(new DeftCrudServiceDataProvider<>(unitTypeService));

//        // Use the name property for item captions
        unitType.setItemLabelGenerator(UnitType::getAlias);

        displacementLayerTypes = new MultiselectComboBox<>("Слой перемещения");
        displacementLayerTypes.setDataProvider(new DeftCrudServiceDataProvider<>(displacementLayerTypeService));

        displacementLayerTypes.setItemLabelGenerator(DisplacementLayerType::getAlias);


        speed = new IntegerField("Unit speed");
        minRange = new IntegerField("Unit minRange");
        range = new IntegerField("Unit range");
        damage = new IntegerField("Unit damage");
        dps = new IntegerField("Unit dps");
        fogOfWarRange = new IntegerField("Unit fogOfWarRange");
        canAttackOnMove = new Checkbox("Unit Can Attack On Move");
        canAttackOnMove.getStyle().set("padding-top", "var(--lumo-space-m)");
        unitFirstFireCooldown = new IntegerField("Unit First Fire Cooldown");

        AbstractField<?, ?>[] fields = new AbstractField<?, ?>[]{
                name
                , description
                , cost
                , count
                , addCapacity
                , unitHealth
                , unitsInGroup
                , unitType
                , displacementLayerTypes
                , speed
                , minRange
                , range
                , damage
                , dps
                , fogOfWarRange
                , canAttackOnMove
                , unitFirstFireCooldown
        };

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

    private void populateForm(Unit value) {
        this.unit = value;
        binder.readBean(this.unit);
    }
}
