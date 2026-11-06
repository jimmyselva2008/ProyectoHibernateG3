module com.tuempresa.practicahibernate {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;

    requires java.sql;
    requires java.naming;
    requires org.hibernate.orm.core;
    requires org.postgresql.jdbc;

    opens com.tuempresa.practicahibernate to javafx.fxml;

    opens com.tuempresa.practicahibernate.controller
            to javafx.fxml;

    opens com.tuempresa.practicahibernate.model
            to javafx.base, org.hibernate.orm.core;

    exports com.tuempresa.practicahibernate;
}