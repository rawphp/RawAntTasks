/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crazydev.ant.tasks;

import org.apache.tools.ant.Project;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tom
 */
public class SubstringTest
{
    protected Substring task;
    protected Project project;
    
    private String _propertyName        = "my_property";
    private String _finalPropertyName   = "finalProperty";
    
    @Before
    public void setUp( )
    {
        this.task = new Substring( );
        
        this.project = new Project( );
        this.task.setProject( this.project );
    }
    
    @After
    public void tearDown( )
    {
        this.task = null;
        this.project = null;
    }

    /**
     * Test to make sure task instantiates correctly.
     */
    @Test
    public void testTaskInstantiatedCorrectly( )
    {
        assertNotNull( this.task );
    }
    
    /**
     * Test of execute method, of class Substring.
     */
    @Test
    public void testExecuteWithStartAndEndIndexes( )
    {
        String value = "10.1";
        
        this.task.setText( value );
        this.task.setStart( 0 );
        this.task.setEnd( 2 );
        this.task.setProperty( this._finalPropertyName );
        this.task.execute( );
        
        assertEquals( "10", this.project.getProperties( ).get( this._finalPropertyName ) );
    }
    
    /**
     * Test of execute method, of class Substring
     */
    @Test
    public void testExecuteWithStartAndString( )
    {
        String value = "10.1";
        
        this.task.setText( value );
        this.task.setStart( 0 );
        this.task.setTo( "." );
        this.task.setProperty( this._finalPropertyName );
        this.task.execute( );
        
        assertEquals( "10", this.project.getProperties( ).get( this._finalPropertyName ) );
    }
}
