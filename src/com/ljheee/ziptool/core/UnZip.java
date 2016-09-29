package com.ljheee.ziptool.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class UnZip {

	File targetFile;

	public UnZip(File file) {
		targetFile = file;
	}

	public void unZipFiles(File srcfile) {

		FileOutputStream out = null;
		try {
			out = new FileOutputStream(targetFile);

			String basedir = "";

			if (srcfile.isDirectory()) {
				System.out.println("jieÑ¹Ëõ£º" + basedir + srcfile.getName());
				this.unZipDirectory(srcfile, out, basedir);
			} else {
				System.out.println("jieÑ¹Ëõ£º" + basedir + srcfile.getName());
				this.unZipFile(srcfile, out, basedir);
			}

			System.out.println("jieÑ¹ËõÍê±Ï");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void unZipFile(File file, FileOutputStream out, String basedir) {
		try {
			ZipFile zipfile = new ZipFile(file);
			for (Enumeration entries = zipfile.entries(); entries.hasMoreElements();) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				String zipEntryName = entry.getName();
				System.out.println("zipEntryName" + zipEntryName);
				InputStream in = zipfile.getInputStream(entry);

				out = new FileOutputStream(zipEntryName);
				byte[] buf1 = new byte[1024];
				int len;
				while ((len = in.read(buf1)) > 0) {
					out.write(buf1, 0, len);
				}
				in.close();
				out.close();
			}

		} catch (ZipException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void unZipDirectory(File file, FileOutputStream out, String basedir) {
		
	}
	
	
	
	

}
