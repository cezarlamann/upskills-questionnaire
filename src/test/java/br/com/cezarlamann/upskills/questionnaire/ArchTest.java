package br.com.cezarlamann.upskills.questionnaire;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("br.com.cezarlamann.upskills.questionnaire");

        noClasses()
            .that()
            .resideInAnyPackage("br.com.cezarlamann.upskills.questionnaire.service..")
            .or()
            .resideInAnyPackage("br.com.cezarlamann.upskills.questionnaire.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..br.com.cezarlamann.upskills.questionnaire.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
