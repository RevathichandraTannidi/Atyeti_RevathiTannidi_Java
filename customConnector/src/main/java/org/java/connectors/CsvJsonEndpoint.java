package org.java.connectors;


import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.support.DefaultEndpoint;

public class CsvJsonEndpoint extends DefaultEndpoint {

    public CsvJsonEndpoint(String endpointUri,
                           CsvJsonComponent component) {
        super(endpointUri, component);
    }

    @Override
    public Producer createProducer() {
        return new CsvJsonProducer(this);
    }

    @Override
    public Consumer createConsumer(Processor processor) {
        throw new UnsupportedOperationException(
                "Consumer not supported");
    }
}