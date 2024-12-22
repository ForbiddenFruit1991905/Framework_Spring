package ru.example.task2.repositories
        ;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.example.task2.model.Account;
import ru.example.task2.repositories.mappers.AccountRowMapper;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Repository
public class AccountRepository {
    private final JdbcTemplate jdbc;

    public Account findAccountById(long id){
        String sql = "SELECT * FROM account WHERE id = ?";
        return jdbc.queryForObject(sql, new AccountRowMapper(), id);
    }

    public List<Account> findAllAccounts(){
        String sql = "SELECT * FROM account";
        return jdbc.query(sql, new AccountRowMapper());
    }

    public void changeAmount(long id, BigDecimal amount){
        String sql = "UPDATE account SET amount = ? WHERE id = ?";
        jdbc.update(sql, amount, id);
    }
}
