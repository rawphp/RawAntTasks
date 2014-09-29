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

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * Ant task to reset a property value.
 * 
 * @author Tom Kaczocha
 */
public class PropertySet extends Task
{
    private String _name        = null;
    private String _value       = null;
    
    /**
     * Resets a property value.
     * 
     * @throws BuildException 
     */
    @Override
    public void execute( ) throws BuildException
    {
        this.getProject( ).setProperty( this._name, this._value );
    }
    
    /**
     * Sets the property name.
     * 
     * @param name property name
     */
    public void setName( String name )
    {
        this._name = name;
    }
    
    /**
     * Sets the property value.
     * 
     * @param value property value
     */
    public void setValue( String value )
    {
        this._value = value;
    }
}
