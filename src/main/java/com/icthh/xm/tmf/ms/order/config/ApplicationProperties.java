package com.icthh.xm.tmf.ms.order.config;

import com.icthh.xm.commons.lep.TenantScriptStorage;
import java.util.Collections;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Order.
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private final Lep lep = new Lep();
    private List<String> tenantIgnoredPathList = Collections.emptyList();
    private final Retry retry = new Retry();
    private boolean kafkaEnabled;
    private String kafkaSystemTopic;
    private String kafkaSystemQueue;
    private boolean timelinesEnabled;

    @Getter
    @Setter
    public static class Lep {
        private TenantScriptStorage tenantScriptStorage;
        private String lepResourcePathPattern;
    }

    @Data
    private static class Retry {
        private int maxAttempts;
        private long delay;
        private int multiplier;
    }
}
