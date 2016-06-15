package homework6;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.*;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

public class MyLogger {
    private static final LoggerContext loggerContext = initLoggerContext();
    private static final Logger logger = loggerContext.getLogger(MyLogger.class.getSimpleName());

    private static LoggerContext initLoggerContext() {
        ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();
        builder.setStatusLevel(Level.ERROR);

        FilterComponentBuilder thresholdFilterBuilder = builder.newFilter("ThresholdFilter", Filter.Result.ACCEPT, Filter.Result.NEUTRAL);
        thresholdFilterBuilder.addAttribute("level", Level.DEBUG);
        builder.add(thresholdFilterBuilder);

        LayoutComponentBuilder layoutBuilder = builder.newLayout("PatternLayout");
        layoutBuilder.addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable");

        FilterComponentBuilder markerFilterBuilder = builder.newFilter("MarkerFilter", Filter.Result.DENY, Filter.Result.NEUTRAL);
        markerFilterBuilder.addAttribute("marker", "FLOW");

        AppenderComponentBuilder consoleAppenderBuilder = builder.newAppender("Stdout", "CONSOLE");
        consoleAppenderBuilder.addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);
        consoleAppenderBuilder.add(layoutBuilder);
        consoleAppenderBuilder.add(markerFilterBuilder);
        builder.add(consoleAppenderBuilder);

        AppenderComponentBuilder fileAppenderBuilder = builder.newAppender("file", "FILE");
        fileAppenderBuilder.addAttribute("fileName", "log/log.txt");
        fileAppenderBuilder.add(layoutBuilder);
        fileAppenderBuilder.add(markerFilterBuilder);
        builder.add(fileAppenderBuilder);

        LoggerComponentBuilder loggerComponentBuilder = builder.newLogger("org.apache.logging.log4j", Level.DEBUG);
        loggerComponentBuilder.add(builder.newAppenderRef("Stdout")).add(builder.newAppenderRef("file")).addAttribute("additivity", false);
        builder.add(loggerComponentBuilder);

        builder.add(builder.newRootLogger(Level.ERROR).add(builder.newAppenderRef("file")).add(builder.newAppenderRef("Stdout")));
        return Configurator.initialize(builder.build());
    }

    public static void log(String info) {
        logger.info(info);
    }
}