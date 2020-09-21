package org.launchcode.techjobs_oo.Tests;

//How do you use @Before and not @BeforeClass? My id was wrong when I used @Before

import org.junit.BeforeClass;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JobTest {
    //    beforeclass requires variables to be static
    private static Job job1;
    private static Job job2;
    private static Job job3;

    @BeforeClass
    public static void createJobs() {
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St Louis"), new PositionType("Front-end Developer"), new CoreCompetency("JavaScript"));
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testJobIDIteration() {
        assertEquals(1, job2.getId() - job1.getId());
    }

    @Test
    public void testJobIDIteration2() {
        assertEquals(2, job3.getId() - job1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job1.getName().equals("Product tester"));
        assertEquals(1, job1.getId());
        assertTrue(job1.getEmployer() instanceof Employer);
        assertEquals("ACME", job1.getEmployer().toString());
        assertTrue(job1.getLocation() instanceof Location);
        assertEquals("Desert", job1.getLocation().toString());
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job1.getPositionType().toString());
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job1.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality() {
        assertEquals(false, job1.equals(job3));
    }

    @Test
    public void testBlanksInToString() {
        assertTrue(job1.toString().contains(""));
    }

    @Test
    public void testLabelsInToString() {
        assertTrue(job1.toString().contains("ID: "));
    }

    @Test
    public void testValuesInToString() {
        System.out.println(job1.toString());
    }

    @Test
    public void testEmptyFieldInToString() {
        Job job4 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Recognize a Coyote"));
        assertTrue(job4.toString().contains("Data not available"));
    }
}
