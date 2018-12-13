package test.boot.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

class TemplateFileScaner {

	private static final String TEMPLATE_ROOT_PATH = "template/";
	
	public List<TemplateFile> scan(String module){
		String modulePath = createFilePath(module);
		List<File> files = new ArrayList<>(
				FileUtils.listFiles(
						new File(modulePath), 
						TrueFileFilter.INSTANCE, 
						TrueFileFilter.INSTANCE));
		
		return files.stream().map(f -> {
			return createTemplateFile(f.getName(), f, f.getPath());
		}).collect(Collectors.toList());
	}
	
	public TemplateFile createTemplateFile(String name, File content, String path) {
		try {
			TemplateFile result = new TemplateFile();
			result.setName(name);
			result.setContent(FileUtils.readFileToString(content, "UTF-8"));
			result.setPath(getRootAelativePath(path));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public String createFilePath(String module) {
		if (module.startsWith("/")) {
			return TEMPLATE_ROOT_PATH + module.substring(1);
		} else {
			return TEMPLATE_ROOT_PATH + module;
		}
	}
	
	private String getRootAelativePath(String path) {
		return path.substring(TEMPLATE_ROOT_PATH.length());
	}
}
