/**
 * This file is part of RawAntTasks - a collection of Ant tasks.
 * 
 * Copyright (c) 2014 Tom Kaczocha
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 * @category  Java
 * @package   org.crazydev.ant.tasks
 * @author    Tom Kaczohca <tom@crazydev.org>
 * @copyright 2014 Tom Kaczocha
 * @license   http://crazydev.org/license.txt MIT
 * @link      http://crazydev.org/
 */

package org.crazydev.ant.tasks;

import java.util.Enumeration;
import java.util.Hashtable;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Property;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tom
 */
public class PropertySetTest
{
    protected PropertySet task;
    protected Project project;
    
    private final String _propertyName        = "my_property";
    private final String _propertyValue       = "my_first_value";
    
    @Before
    public void setUp( )
    {
        this.task = new PropertySet( );
        
        this.project = new Project( );
        this.task.setProject( this.project );
        
        this.project.setNewProperty( this._propertyName, this._propertyValue );
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
     * Test of execute method, of class PropertySet.
     */
    @Test
    public void testExecute( )
    {
        String newValue = "my_new_value";
        
        assertNotNull( this.project );
        assertNotNull( this.project.getProperties( ) );
        assertTrue( this.project.getProperties( ).size( ) > 0 );
        
        this.task.setName( this._propertyName );
        this.task.setValue( newValue );
        this.task.execute( );
        
        assertEquals( newValue, this.project.getProperties( ).get( this._propertyName ) );
    }
}
