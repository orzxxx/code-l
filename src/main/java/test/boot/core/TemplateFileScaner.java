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
		String modulePath = createModulePath(module);
		List<File> files = new ArrayList<>(
				FileUtils.listFiles(
						new File(modulePath), 
						TrueFileFilter.INSTANCE, 
						TrueFileFilter.INSTANCE));
		
		return files.stream().map(f -> {
			try {
				TemplateFile tf = new TemplateFile();
				tf.setContent(FileUtils.readFileToString(f, "UTF-8"));
				tf.setName(f.getName());
				tf.setPath(getRootAelativePath(f.getPath()));
				return tf;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
		}).collect(Collectors.toList());
	}
	
	private String createModulePath(String module) {
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
