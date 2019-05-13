package com.uneedcomms.kafkaproducer.permission;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data @ToString
@RedisHash("permissions")
@EqualsAndHashCode(of = "key")
public class Permissions {

    @Id
    // dw_permissions Key 컬럼, 업체별 고유값
    private String key;
    // dw_permissions app_id 컬럼, 업체명
    private String appId;
    // ims_domains status 컬럼, ims_domains.ims_app_id = dw_permissions.app_id
    private String status;

}
