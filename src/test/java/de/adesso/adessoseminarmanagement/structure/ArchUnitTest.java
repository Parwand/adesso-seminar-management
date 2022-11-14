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

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

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
            .because("For less coupling between component and Injection with constructor");

    @ArchTest
    static final ArchRule noFieldShouldBePublicInDomainModelSeminar = fields()
            .that()
            .areDeclaredIn(Seminar.class)
            .should()
            .notBePublic()
            .because("For less coupling between component and Injection with constructor");

    @ArchTest
    static final ArchRule noFieldShouldBePublicInDomainModelSeminarraum = fields()
            .that()
            .areDeclaredIn(Seminarraum.class)
            .should()
            .notBePublic()
            .because("For less coupling between component and Injection with constructor");

    @ArchTest
    static final ArchRule noFieldShouldBePublicInDomainModelSeminarBuchung = fields()
            .that()
            .areDeclaredIn(Seminarbuchung.class)
            .should()
            .notBePublic()
            .because("For less coupling between component and Injection with constructor");

    @ArchTest
    static final ArchRule reposClassShouldEndWithNameRepository = classes()
            .that()
            .resideInAPackage("..repository..")
            .should()
            .haveSimpleNameEndingWith("Repository")
            .because("For better structure");
}
