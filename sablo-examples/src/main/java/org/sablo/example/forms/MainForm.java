/*
 This file belongs to the Servoy development and deployment environment, Copyright (C) 1997-2014 Servoy BV

 This program is free software; you can redistribute it and/or modify it under
 the terms of the GNU Affero General Public License as published by the Free
 Software Foundation; either version 3 of the License, or (at your option) any
 later version.

 This program is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License along
 with this program; if not, see http://www.gnu.org/licenses or write to the Free
 Software Foundation,Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301
 */

package org.sablo.example.forms;

import org.sablo.Container;
import org.sablo.IEventHandler;
import org.sablo.WebComponent;
import org.sablo.specification.WebComponentSpecification;

/**
 * @author rgansevles
 *
 */
public class MainForm extends Container
{

	/**
	 * @param name
	 * @param spec
	 */
	public MainForm(String name, WebComponentSpecification spec)
	{
		super(name, spec);

		final WebComponent theLabel = new WebComponent("mylabel", "thelabel");
		theLabel.setProperty("text", "initial server value");
		add(theLabel);

		final WebComponent theTextField = new WebComponent("mytextfield", "thetextfield");
		theTextField.setProperty("value", "changeme");
		add(theTextField);

		final WebComponent theCounter = new WebComponent("mycounter", "thecounter");
		add(theCounter);

		WebComponent theButton = new WebComponent("mybutton", "thebutton");
		theButton.addEventHandler("pushed", new IEventHandler()
		{
			@Override
			public Object executeEvent(Object[] args)
			{
				System.err.println("I was pushed!");
				// copy value from text field to label, will be automatically synchronised to browser
				Object textvalue = theTextField.getProperty("value");
				theLabel.setProperty("text", textvalue);
				// call a function on an element
				theCounter.invokeApi("increment", new Object[] { 2 });

				return 42;
			}
		});
		add(theButton);

	}

}
