package de.adesso.adessoseminarmanagement.structure;


import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import de.adesso.adessoseminarmanagement.Application;
import de.adesso.adessoseminarmanagement.domain.model.person.Person;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminar;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarbuchung;
import de.adesso.adessoseminarmanagement.domain.model.seminar.Seminarraum;
import org.springframework.stereotype.Controller;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packagesOf = Application.class, importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchUnitTest {

    @ArchTest
    static final ArchRule noClassesAccessToController = noClasses()
            .that()
            .resideOutsideOfPackage("..infrastructure.controller..")
            .should()
            .accessClassesThat()
            .areAnnotatedWith(Controller.class);

    @ArchTest
    static final ArchRule noFieldShouldBePublicInDomainModelPerson = fields()
            .that()
            .areDeclaredIn(Person.class)
            .should()
            .notBePublic()
            .because("For less coupling between component");

    @ArchTest
    static final ArchRule noFieldShouldBePublicInDomainModelSeminar = fields()
            .that()
            .areDeclaredIn(Seminar.class)
            .should()
            .notBePublic()
            .because("For less coupling between component");
}
