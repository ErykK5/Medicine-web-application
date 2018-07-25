package com.company.vaadindb.ui;

import com.company.vaadindb.controllers.MedController;
import com.company.vaadindb.dao.MedDAO;
import com.company.vaadindb.model.Med;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("mytheme")
public class VaadinUI extends UI {

    @Autowired
    private MedDAO medDAO;

    @Autowired
    private MedController medController;

    HorizontalLayout root = new HorizontalLayout();

    private Binder<Med> binder = new Binder<>(Med.class);
    private Grid<Med> grid = new Grid( Med.class );
    private TextField name = new TextField("Name");
    private TextField numb = new TextField("Quantity");
    private TextField ident = new TextField("ID");
    private Button add = new Button("Add" , e -> saveCustomer());
    private Button del = new Button("Delete" , e -> saveCustomer());

    @Override
    protected void init( VaadinRequest request) {
        initLayout();
        initBehavior();
    }

    private void initBehavior(){
        add.addClickListener( click->{
            medController.create( name.getValue(), numb.getValue() );
            updateGrid();
        });

        del.addClickListener( click->{
            medController.delete( Long.parseLong( ident.getValue() ) );
            updateGrid();
        });

    }

    private void initLayout(){
        updateGrid();
        grid.setColumns("id","name", "numb");
        binder.bindInstanceFields(this );
        VerticalLayout layout = new VerticalLayout( grid );
        VerticalLayout layout2 = new VerticalLayout( name, numb, add );
        VerticalLayout layout3 = new VerticalLayout( ident, del );



        root.addComponents( layout, layout2, layout3 );
        setContent(root);
    }

    private void updateGrid() {
        grid.setItems( medDAO.findAll() );
    }

    private void saveCustomer() {
        updateGrid();
    }
}