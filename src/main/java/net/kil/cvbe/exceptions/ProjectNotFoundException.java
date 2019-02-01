/*
 * Copyright (c) 2019. Killiko
 * @author Alexander.Kill@gmail.com
 */
package net.kil.cvbe.exceptions;

public class ProjectNotFoundException extends RuntimeException {

	public ProjectNotFoundException(Long id) {
		super("Could not find project " + id);
	}
}
