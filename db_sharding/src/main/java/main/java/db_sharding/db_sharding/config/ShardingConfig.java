package main.java.db_sharding.db_sharding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class ShardingConfig {

    @Bean
    private DataSource dataSourceForShard(String shard) {
        // This is a simplified version. You would need to configure actual DB connection parameters.
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        if ("ds0".equals(shard)) {
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/shard0");
            dataSource.setUsername("username");
            dataSource.setPassword("password");
        } else if ("ds1".equals(shard)) {
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/shard1");
            dataSource.setUsername("username");
            dataSource.setPassword("password");
        }
    
        return dataSource;
    }
    
}
