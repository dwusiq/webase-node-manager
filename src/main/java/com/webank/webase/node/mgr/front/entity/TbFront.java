/**
 * Copyright 2014-2020  the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.webank.webase.node.mgr.front.entity;

import java.time.LocalDateTime;

import com.webank.webase.node.mgr.base.enums.FrontStatusEnum;
import com.webank.webase.node.mgr.base.enums.RunTypeEnum;

import lombok.Data;

@Data
public class TbFront {
    private Integer frontId;
    private String nodeId;
    private String frontIp;
    private Integer frontPort;
    private String agency;
    /**
     * node version
     */
    private String clientVersion;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    /**
     * front status by now
     * @case1: front's node is abnormal
     * @case2: front's request fail/no response
     */
    private Integer status;


    private Byte runType;
    private Integer agencyId;
    private String agencyName;
    private Integer hostId;
    private Short hostIndex;
    private String imageTag;
    private String containerName;
    private Short jsonrpcPort;
    private Short p2pPort;
    private Short channelPort;

    public static TbFront init(
            String nodeId,
            String ip,
            int port,
            String agencyName,
            String clientVersion,
            RunTypeEnum runTypeEnum,
            int agencyId,
            int hostId,
            short hostIndex,
            String imageTag,
            String containerName ,
            short jsonrpcPort,
            short p2pPort,
            short channelPort,
            FrontStatusEnum frontStatusEnum
    ){
        LocalDateTime now = LocalDateTime.now();
        TbFront front = new TbFront();
        front.setNodeId(nodeId);
        front.setFrontIp(ip);
        front.setFrontPort(port);
        front.setAgency(agencyName);
        front.setClientVersion(clientVersion);
        front.setCreateTime(now);
        front.setModifyTime(now);
        front.setRunType(runTypeEnum.getId());
        front.setAgencyId(agencyId);
        front.setAgencyName(agencyName);
        front.setHostId(hostId);
        front.setHostIndex(hostIndex);
        front.setImageTag(imageTag);
        front.setContainerName(containerName);
        front.setJsonrpcPort(jsonrpcPort);
        front.setP2pPort(p2pPort);
        front.setChannelPort(channelPort);
        front.setStatus(frontStatusEnum.getId());

        return front;
    }

}



