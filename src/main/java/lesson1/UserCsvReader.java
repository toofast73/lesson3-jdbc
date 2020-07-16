package lesson1;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class UserCsvReader {

    public List<User> readCsv(File input) throws IOException {

        CsvSchema schema = CsvSchema.builder()
                .addNumberColumn("id")
                .addColumn("name")
                .addColumn("email")
                .setUseHeader(true)
                .build()
                .withHeader()
                .withColumnSeparator(';');

        ObjectMapper mapper = new CsvMapper();
        MappingIterator<User> objectMappingIterator = mapper.readerFor(User.class).with(schema).readValues(input);

        return objectMappingIterator.readAll();
    }

}
