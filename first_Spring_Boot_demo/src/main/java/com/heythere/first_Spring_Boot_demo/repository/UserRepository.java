package com.heythere.first_Spring_Boot_demo.repository;

import com.heythere.first_Spring_Boot_demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User} {@link Repository}
 */
@Repository
public class UserRepository {
    /**
     * 采用内存型的存储方式：Map
     */
    private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();
    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * 保存用户对象
     * @param user {@link User} 对象
     * @return 如果保存成功，返回<code>true</code>，否则返回<code>false</code>
     */
    public boolean save(User user) {
        //id从1开始
        int id = idGenerator.incrementAndGet();

        //设置id
        user.setId(id);
        return null == repository.put(id, user);
    }

    /**
     * 返回所有用户列表
     * @return
     */
    public Collection<User> findAll() {
        return repository.values();
    }
}
