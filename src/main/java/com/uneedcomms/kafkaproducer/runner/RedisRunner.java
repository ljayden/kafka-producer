package com.uneedcomms.kafkaproducer.runner;

import com.uneedcomms.kafkaproducer.permission.Permissions;
import com.uneedcomms.kafkaproducer.permission.PermissionsRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RedisRunner implements ApplicationRunner {

    private PermissionsRepository permissionsRepository;

    public RedisRunner(PermissionsRepository permissionsRepository) {
        this.permissionsRepository = permissionsRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Permissions permissions = new Permissions();
        permissions.setKey("d3d16d94-e633-11e7-80c1-9a214cf093ae");
        permissions.setAppId("uneedcommscom");
        permissions.setStatus("active");
        Permissions savedPermission01 = permissionsRepository.save(permissions);
        System.out.println(savedPermission01);

        permissions.setKey("01816281-4171-457a-8428-701b97ee4401");
        permissions.setAppId("justone");
        permissions.setStatus("inactive");
        Permissions savedPermission02 = permissionsRepository.save(permissions);
        System.out.println(savedPermission02);

        permissions.setKey("db9e3a7c-fe9b-4107-b61c-bba47553f05c");
        permissions.setAppId("roompacker");
        permissions.setStatus("active");
        Permissions savedPermission03 = permissionsRepository.save(permissions);
        System.out.println(savedPermission03);


    }
}
