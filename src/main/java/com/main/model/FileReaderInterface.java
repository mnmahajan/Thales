package com.main.model;


/**
 * @author ACER
 *	Filereader interface, parent for all formats file readers
 */
@FunctionalInterface
public interface FileReaderInterface {
	
	public abstract void setFilePath(String filePath);

}
