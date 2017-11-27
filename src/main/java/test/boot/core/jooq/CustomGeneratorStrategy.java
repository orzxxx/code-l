package test.boot.core.jooq;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.jooq.tools.StringUtils;
import org.jooq.util.CatalogDefinition;
import org.jooq.util.DefaultGeneratorStrategy;
import org.jooq.util.Definition;
import org.jooq.util.SchemaDefinition;
import org.jooq.util.GeneratorStrategy.Mode;

public class CustomGeneratorStrategy extends DefaultGeneratorStrategy {
	 /**
     * Override this to specifiy what identifiers in Java should look like.
     * This will just take the identifier as defined in the database.
     */
    @Override
    public String getJavaIdentifier(Definition definition) {
        return super.getJavaIdentifier(definition);
    }

    /**
     * Override these to specify what a setter in Java should look like. Setters
     * are used in TableRecords, UDTRecords, and POJOs. This example will name
     * setters "set[NAME_IN_DATABASE]"
     */
    @Override
    public String getJavaSetterName(Definition definition, Mode mode) {
        return super.getJavaSetterName(definition, mode);
    }

    /**
     * Just like setters...
     */
    @Override
    public String getJavaGetterName(Definition definition, Mode mode) {
        return super.getJavaGetterName(definition, mode);
    }

    /**
     * Override this method to define what a Java method generated from a database
     * Definition should look like. This is used mostly for convenience methods
     * when calling stored procedures and functions. This example shows how to
     * set a prefix to a CamelCase version of your procedure
     */
    @Override
    public String getJavaMethodName(Definition definition, Mode mode) {
        return super.getJavaMethodName(definition, mode);
    }

    /**
     * Override this method to define how your Java classes and Java files should
     * be named. This example applies no custom setting and uses CamelCase versions
     * instead
     */
    @Override
    public String getJavaClassName(Definition definition, Mode mode) {
    	String name = getFixedJavaClassName(definition);

        if (name != null)
            return name;
        else
            return getJavaClassName0(definition, mode);
    }
    
    private String getFixedJavaClassName(Definition definition) {

        // [#2032] Intercept default catalog
        if (definition instanceof CatalogDefinition && ((CatalogDefinition) definition).isDefaultCatalog())
            return "DefaultCatalog";

        // [#2089] Intercept default schema
        else if (definition instanceof SchemaDefinition && ((SchemaDefinition) definition).isDefaultSchema())
            return "DefaultSchema";

        else
            return null;
    }
    
    private String getJavaClassName0(Definition definition, Mode mode) {
        StringBuilder result = new StringBuilder();

		String outputName = definition.getOutputName()
				.replace(' ', '_')
				.replace('-', '_')
				.replace('.', '_');
		
		// 去掉生成的类中T和V前缀
		if (outputName.startsWith("T_") || outputName.startsWith("V_")) {
			outputName = outputName.substring(2);
		}
		
        // [#4562] Some characters should be treated like underscore
        result.append(StringUtils.toCamelCase(outputName));

        if (mode == Mode.RECORD) {
            result.append("Record");
        }
        else if (mode == Mode.DAO) {
            result.append("Dao");
        }
        else if (mode == Mode.INTERFACE) {
            result.insert(0, "I");
        }

        return result.toString();
    }
    
    /**
     * Override this method to re-define the package names of your generated
     * artefacts.
     */
    @Override
    public String getJavaPackageName(Definition definition, Mode mode) {
        return super.getJavaPackageName(definition, mode);
    }

    /**
     * Override this method to define how Java members should be named. This is
     * used for POJOs and method arguments
     */
    @Override
    public String getJavaMemberName(Definition definition, Mode mode) {
        return super.getJavaMemberName(definition, mode);
    }

    /**
     * Override this method to define the base class for those artefacts that
     * allow for custom base classes
     */
    @Override
    public String getJavaClassExtends(Definition definition, Mode mode) {
        return super.getJavaClassExtends(definition, mode);
    }

    /**
     * Override this method to define the interfaces to be implemented by those
     * artefacts that allow for custom interface implementation
     */
    @Override
    public List<String> getJavaClassImplements(Definition definition, Mode mode) {
        return super.getJavaClassImplements(definition, mode);
    }

    /**
     * Override this method to define the suffix to apply to routines when
     * they are overloaded.
     *
     * Use this to resolve compile-time conflicts in generated source code, in
     * case you make heavy use of procedure overloading
     */
    @Override
    public String getOverloadSuffix(Definition definition, Mode mode, String overloadIndex) {
        return super.getOverloadSuffix(definition, mode, overloadIndex);
    }
}
