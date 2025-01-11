package main.java.db_sharding.db_sharding.config;

@Configuration
@EnableTransactionManagement
@Primary // Mark this as the primary data source
public class DatabaseConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSourceConfig dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, DataSourceConfig dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.shardingdemo.entity") // Specify the package containing your entities
                .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}