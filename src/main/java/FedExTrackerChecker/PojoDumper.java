package FedExTrackerChecker;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PojoDumper {
    public static void main(String... args) throws IOException {
        URL url = new File("C:\\Users\\Ian\\IdeaProjects\\FedExTrackingChecker\\src\\main\\resources\\test.json").toURI().toURL();
        File file = new File("C:\\Users\\Ian\\IdeaProjects\\FedExTrackingChecker\\src\\main\\java\\FedExTrackerChecker\\entities\\testpojo");
        System.out.println(url);
        System.out.println(file);
        convertJsonToJavaClass(url, file, "FedExTrackerChecker.entities.testpojo", "BulkTrackingResponse");
    }

    public static void convertJsonToJavaClass(URL inputJsonUrl, File outputJavaClassDirectory, String packageName, String javaClassName)
            throws IOException {
        JCodeModel jcodeModel = new JCodeModel();

        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() {
                return true;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSON;
            }
        };

        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        mapper.generate(jcodeModel, javaClassName, packageName, inputJsonUrl);

        jcodeModel.build(outputJavaClassDirectory);
    }
}
