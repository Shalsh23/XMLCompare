package com.mycompany.app;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.xmlunit.diff.DefaultNodeMatcher;
import org.xmlunit.diff.Diff;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.ElementSelectors;
import org.xmlunit.matchers.CompareMatcher;

/**
 * Unit test for simple App.
 * Reference: https://www.baeldung.com/xmlunit2
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }

    @org.junit.jupiter.api.Test
    public void given2XMLS_whenIdentical_thenCorrect() {
        String controlXml = "<struct><int>3</int><boolean>false</boolean></struct>";
        String testXml = "<struct><int>3</int><boolean>false</boolean></struct>";
        assertThat(testXml, CompareMatcher.isIdenticalTo(controlXml));

//        ClassLoader classLoader = getClass().getClassLoader();
//        String oldFile = classLoader.getResource("CTD_chem_gene_ixns_structured.xml").getPath();
//        String newFile = classLoader.getResource("CTD_chem_gene_ixns_structured.xml").getPath();
        File oldFile = new File("/scratch/spshriva/XMLCompare/my-app/CTD_chem_gene_ixns_structured.xml");
        File newFile = new File("/scratch/spshriva/XMLCompare/my-app/newFile/CTD_chem_gene_ixns_structured.xml");

        Diff myDiffSimilar = DiffBuilder.compare(oldFile).withTest(newFile)
                .withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byName))
                .checkForSimilar().build();

        assertFalse("XML similar " + myDiffSimilar.toString(),
                myDiffSimilar.hasDifferences());

        System.out.println(myDiffSimilar.getDifferences());
    }
}
