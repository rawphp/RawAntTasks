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
 * Ant task to get a substring from a string.
 * 
 * @author Tom Kaczocha
 */
public class Substring extends Task
{
    private String _text        = null;
    private int _start          = 0;
    private int _end            = -1;
    private String _to          = null;
    private String _property    = null;
    
    /**
     * Creates a substring from supplied text parameters
     * and sets it to the requested property.
     * 
     * @throws BuildException 
     */
    @Override
    public void execute( ) throws BuildException
    {
        if ( -1 == this._end )
        {
            this._end = this._text.indexOf( this._to );
        }
        if ( -1 == this._end )
        {
            this._end = this._text.length( ) - 1;
        }
        
        String text = this._text.substring( this._start, this._end );
        
        this.getProject( ).setProperty( this._property, text );
    }
    
    /**
     * Sets the original text string.
     * 
     * @param text the original text
     */
    public void setText( String text )
    {
        this._text = text;
    }
    
    /**
     * Sets the start index of the substring.
     * 
     * @param start the start index of the substring - inclusive
     */
    public void setStart( int start )
    {
        this._start = start;
    }
    
    /**
     * Sets the end index of the substring.
     * 
     * @param end the end index - exclusive
     */
    public void setEnd( int end )
    {
        this._end = end;
    }
    
    /**
     * Sets the to substring.
     * 
     * @param to the to substring - exclusive
     */
    public void setTo( String to )
    {
        this._to = to;
    }
    
    /**
     * Sets the property name.
     * 
     * @param property the name of the property to assign to
     */
    public void setProperty( String property )
    {
        this._property = property;
    }
}
