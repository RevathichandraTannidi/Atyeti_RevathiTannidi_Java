package org.java.connectors;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultProducer;

import java.util.List;
import java.util.Map;

public class CsvJsonProducer extends DefaultProducer {

    public CsvJsonProducer(CsvJsonEndpoint endpoint) {
        super(endpoint);
    }

    @Override
    public void process(Exchange exchange)
            throws Exception {

        String csv = exchange.getMessage().getBody(String.class);

        CsvMapper csvMapper = new CsvMapper();

        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        MappingIterator<Map<String, String>> iterator = csvMapper.readerFor(Map.class).with(schema)
                        .readValues(csv);

        List<Map<String, String>> rows = iterator.readAll();

        String json =
                new com.fasterxml.jackson.databind.ObjectMapper()
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(rows);

        exchange.getMessage().setBody(json);
    }
}