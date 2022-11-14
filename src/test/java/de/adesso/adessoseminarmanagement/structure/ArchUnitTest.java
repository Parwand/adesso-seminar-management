package de.adesso.adessoseminarmanagement.structure;


import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import de.adesso.adessoseminarmanagement.Application;

@AnalyzeClasses(packagesOf = Application.class, importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchUnitTest {
}
