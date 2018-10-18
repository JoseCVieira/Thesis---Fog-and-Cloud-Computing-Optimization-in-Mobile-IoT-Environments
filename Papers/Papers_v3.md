[Doubts]
-----------------------------------------------------------------------------------

-----------------------------------------------------------------------------------
- VM/resource scheduling
- Data placement
- Virtual objects / application decomposition in modules / foglets
- Handover
- Predicted mobility patterns
- Virtual objects

-----------------------------------------------------------------------------------
2015 **An architecture for Load Balancing Techniques for Fog Computing Environment.** 

This paper proposes a new architecture based on load balancing algorithm in Fog Computing environment. Users sent the request to the nearby Fog servers which are consistently maintaining the frequently used data. In case, the users don’t get the desired resource in nearby Fog Servers who are also communicating with each other, then that request is forwarded to the cloud servers. To implement this load balancing algorithm they use modified Honey Bee Based algorithm.

**Note: load balancing ?**

-----------------------------------------------------------------------------------
2012 **Energy-Efficient Multi-Job Scheduling Model for Cloud Computing and Its Genetic Algorithm**

For the problem that the energy efficiency of the cloud computing data center is low, they propose a new energy-efficient multi-job scheduling model. To solve this model, they design an encoding and decoding method for the individuals and construct an overall energy efficiency function of the servers. Meanwhile, in order to accelerate the convergent speed of this algorithm and enhance its searching ability, a local search operator is introduced.

**Note: job scheduling ?**

-----------------------------------------------------------------------------------
2017 **Computing Resource Allocation in Three-Tier IoT Fog Networks: A Joint Optimization Approach Combining Stackelberg Game and Matching**

This paper considers a specific fog computing network consisting of a set of data service operators (DSOs) each of which controls a set of fog nodes (FNs) to provide the required data service to a set of data service subscribers (DSSs). They address the problem of how to allocate the limited computing resources of FNs to all the DSSs to achieve an optimal and stable performance. Therefore, they propose a joint optimization in a distributed fashion. In the framework, they formulate a Stackelberg game to analyze the pricing problem for the DSOs as well as the resource allocation problem for the DSSs.

**Note: resource allocation ?**

-----------------------------------------------------------------------------------
2017 **Fog computing job scheduling optimization based on bees swarm**

This paper proposes a new bio-inspired optimization approach called BeesLife Algorithm (BLA) aimed at addressing the job scheduling problem in the fog computing environment. This approach is based on the optimized distribution of a set of tasks among all the fog computing nodes. The objective is to find an optimal trade-off between CPU execution time and allocated memory required by fog computing services established by mobile users.

**Note: job scheduling ?**

-----------------------------------------------------------------------------------
[Toolkits]
-----------------------------------------------------------------------------------

-----------------------------------------------------------------------------------
**iFogSim: A toolkit for modeling and simulation of resource management techniques in the Internet of Things, Edge and Fog computing environments**

In this paper they propose a simulator, called iFogSim, to model IoT and Fog environments and measure the impact of resource management techniques in latency, network congestion, energy consumption, and cost.

**Note: important**

-----------------------------------------------------------------------------------
[385] 2017 **Myifogsim: A simulator for virtual machine migration in fog computing**

An extension of iFogSim to support mobility through migration of VMs between cloudlets.

**Note: important?**

----------------------------------------------------------------------------------
[388] 2017 **Edgecloudsim: An environment for performance evaluation of edge computing systems.**

The authors propose another edge computing simulation environment, EdgeCloudSim, that considers both network and computational resources and covers all aspects of edge computing simulation , including network and computational modelling. Similar to iFogSim, EdgeCloudSim relies on CloudSim as well. Additionally, EdgeCloudSim provides a modular architecture to provide support for a variety of critical functionality and supports simulating multi-tier scenarios where multiple edge servers are running in coordination with upper layer cloud solutions.

-----------------------------------------------------------------------------------
[Migration optimization]
-----------------------------------------------------------------------------------

-----------------------------------------------------------------------------------
[237] 2013 **Migcep: operator migration for mobility driven distributed complex event processing**

Most work studying the placement of operators in such an environment completely disregards the migration costs. However, the mobility of users requires frequent migration of operators, together with possibly large state information, to meet latency restrictions and save bandwidth in the infrastructure. In this papers, Beate Ottenwälder et al. **present a placement and migration method** for providers of infrastructures that incorporate cloud and fog resources. **It ensures application-defined end-to-end latency restrictions and reduces the network utilization by planning the migration ahead of time using predicted mobility patterns. Furthermore, present how the application knowledge of the CEP system can be used to improve current live migration techniques for Virtual Machines (VMs) to reduce the required bandwidth during the migration. First, it allows us to amortize the migration costs by selecting migration targets that ensure a low expected network utilization for a sufficiently long time. Second, it allows us to serialize the operator for the migration and migrating parts of the operator a priori in away where unnecessary events are not migrated and bandwidth is reduced.**

**Note: it uses statistics to calculate the migration in advance**

-----------------------------------------------------------------------------------
[231] 2015 **Dynamic service migration and workload scheduling in edge-clouds**

This paper, Rahul Urgaonkar et al. **present a model to optimize operational costs while providing rigorous performance guarantees as a sequential decision-making Markov Decision Problem (MDP).** This model is different from the traditional solution methods (such as dynamic programming) that require extensive statistical knowledge and are computationally prohibitive. **First they establish a decoupling property of the MDP that reduces it to two independent MDPs. Then, using the technique of Lyapunov optimization over renewals they design an online control algorithm that is provably cost-optimal.** When the decoupling property holds, it enables the design of simple online control algorithms that do **not require any knowledge of the underlying statistics of the MDPs**, yet are provably optimal. This technique was applied to **dynamic service migration** and workload scheduling.

**Note: introduction, not very important - [232] its better**

-----------------------------------------------------------------------------------
[232] 2016 **Segue: Quality of service aware edge cloud service migration**

Wuyang Zhang et al. propose **SEGUE, a service that achieves optimal migration decisions by providing a long-term optimal QoS to mobile users. This model arises to overcome the limitations of previous studies that propose a static distance-based Markov Decision Process (MDP) for optimizing migration decisions that although works, it fails to consider dynamic network and server states.** **SEGUE is a MDP-based model** which incorporates the two dominant factors in making migration decisions: 1) network state, and 2) server state. **On top of that SEGUE answers the question of when to recalculate the MDP model, because to short intervals would create heavy overhead, and long intervals may translate into lazy migration. SEGUE adopts a QoS aware scheme to activate the MDP model when a QoS violation is predicted to solve for the when to migrate variable.Two components of SEGUE work together to achieve this. One module monitors network states, server workloads and user mobility and the other is responsible for QoS prediction. This allows SEGUE to avoid unnecessary migration costs and bypass any possible QoS violations.**

**Note: introduction, important**

-----------------------------------------------------------------------------------
[217] 2017 **Mobile edge cloud network design optimization**

Alberto Ceselli et al. present a link-path formulations supported by **heuristics to compute solutions in reasonable time to firstly determining where to install cloudlet** facilities and **secondly assigning sets of access points**, such as base stations **to cloudlets and lastly supporting VM orchestration and considering partial user mobility information, as well as the satisfaction of service-level agreements.** Qualify the advantage in considering mobility for both users and VMs. **Compare two VM mobility modes**, determining that high preference should be given to **live migration and bulk migration** seem to be a feasible alternative on delay-stringent tiny-disk services, such as augmented reality support, and only with further relaxation on network constraints. Also, they focus on the potential medium-term planning of an edge cloud network in mobile access networks. **They study two design cases: 1) network in a static state 2) network state variations in terms of load and service level, caused by user mobility.**

**Note: introduction**

-----------------------------------------------------------------------------------
[246] 2016 **Primal: Profit maximization avatar placement for mobile edge computing**

User Equipment (UE) are moving in the network, and so the E2E (between UE and its Avatar) may become worse, degrading QoS. The live Avatar migration is triggered to adjust the location of the UE’s Avatar. However, the **migration process consumes extra resources** of the Avatar that may degrade the performance of applications running in the Avatar. By considering the **gain (i.e., the end-to-end delay reduction)** and the **cost (i.e., the migration overheads)** of the live Avatar (a software clone; high performance Virtual Machine (VM) located in a cloudlet) migration, Xiang Sun et al. propose a PRofIt Maximization Avatar pLacement **(PRIMAL) strategy for the cloudlet network in order to optimize the trade-off between the migration gain and the migration cost by selectively migrating the Avatars to their optimal locations.**

-----------------------------------------------------------------------------------
[123] 2018 **When clones flock near the fog**

Abdelwahab et al. design **FogMQ, a self-deploying brokering clones that discover cloud/edge hosting platforms and autonomously migrate clones between them according to self-measured weighted tail end-to-end latency without the need of a central monitoring and control unit**, not having to sacrifice computation offloading gain in cloud platforms. Finally, it is simple and requires no change in existing cloud platforms controllers.

-----------------------------------------------------------------------------------
[247] 2017 **Towards efficient edge cloud augmentation for virtual reality mmogs**

**One problem remains unsolved: how to distribute the work among the user device, the edge clouds, and the center cloud to meet all three requirements especially when users are mobile.** Wuyang Zhang et al. **propose a hybrid gaming architecture that achieves clever work distribution.** It places local view change updates on edge clouds for immediate responses, frame rendering on edge clouds for high bandwidth, and global game state updates on the center cloud for user scalability. In addition, they propose an efficient service placement algorithm based on a Markov decision process. **This algorithm dynamically places a user’s gaming service on edge clouds while the user moves through different access points taking into account the presence of dynamic network states and server workload states, and user mobility.** However, **unlike many of the service migration solutions which assumes an ignorable service transition time, they acknowledge that it is impossible to migrate an edge service from one edge to another instantly given the size of a VR game world. Therefore, they propose a mechanism to ensure a new edge cloud is activated when a player connects to the new one. It also co-places multiple users to facilitate game world sharing and reduce the overall migration overhead.** Also, they derive optimal solutions and devise efficient heuristic approaches and study different algorithm implementations to speed up the runtime.

**Note: introduction, important following the MDP field**

-----------------------------------------------------------------------------------
2016 **Scalable Fog Computing with Service Offloading in Bus Networks**

In this paper, they **leverage the characteristics of buses** and propose a scalable fog computing paradigm with servicing offloading in bus networks. **The bus fog servers not only provide fog computing services for the mobile users on bus, but also are motivated to accomplish the computation tasks offloaded by roadside cloudlets. By this way, the computing capability of roadside cloudlets is significantly extended. They consider an allocation strategy using genetic algorithm (GA). With this strategy, the roadside cloudlets spend the least cost to offload their computation tasks. Meanwhile, the user experience of mobile users are maintained.**

-----------------------------------------------------------------------------------

[Mobility]
-----------------------------------------------------------------------------------
-----------------------------------------------------------------------------------
[172] 2016 **Vehicular fog computing: A viewpoint of vehicles as the infrastructures**

Xueshi Hou et al. present the idea of utilizing vehicles as the infrastructures for communication and computation, named vehicular fog computing (VFC), which is an architecture that utilizes a collaborative multitude of end-user clients or near-user edge devices to carry out communication and computation, based on better utilization of individual communication and computational resources of each vehicle. They discussed four types of scenarios of moving and parked vehicles or congested traffic. Also, they point out the advantages against vehicular cloud computing (VCC) and the advantages in scenarios like of emergency operations for natural disaster and terrorist attack.

-----------------------------------------------------------------------------------
[186] 2018 **Mobile edge computing via a uav-mounted cloudlet: Optimization of bit allocation and path planning**

Unmanned aerial vehicles (UAVs) have been considered as means to provide computing capabilities. In this model, UAVs act as fog nodes and provide computing capabilities with enhanced coverage for IoT nodes. The system aims at minimizing the total mobile energy consumption while satisfying QoS requirements of the offloaded mobile application. This architecture is based on a UAV-mounted cloudlet which provides the offloading opportunities to multiple static mobile devices. They aim to minimize the mobile energy consumption, while satisfying QoS requirements and optimize UAV’s trajectory.

**Note: introduction, presents a energetic model, will serve for introductory references**

-----------------------------------------------------------------------------------
[270] 2016 **An adaptive cloudlet placement method for mobile applications over gps big data**

Introduces the concept of movable cloudlets and explores the problem of how to cost-effectively deploy these movable cloudlets to enhance cloud services for dynamic context-aware mobile applications. To this end, Haolong Xiang et al. propose an adaptive cloudlet placement (via GPS) method for mobile applications. Specifically, the gathering regions of the mobile devices are identified based on position clustering, and the cloudlet destination locations are confirmed accordingly. Besides, the traces between the origin and destination locations of these mobile cloudlets are also achieved.

**Note: introduction, important?**

-----------------------------------------------------------------------------------
[325] 2017 **Router-based brokering for surrogate discovery in edge computing.**

This paper examines the problem of discovering surrogates, which are micro-clouds, fog nodes, or cloudlets, used by client devices to offload computation tasks in a fog computing environment. In order to enable the discovery and selection of available surrogates, the authors propose a brokering mechanism in which available surrogates advertise themselves to the broker. The broker receives client requests and considers a number of attributes such as network information, hardware capabilities, and distance to find the best available surrogate for the client. The proposed mechanism is implemented on off-the-shelf home routers. They look at the problem of surrogate discovery in the context of an urban area, where they are faced with a high mobility of devices and users. Multiple brokers are interconnected using Distributed Hash Tables (DHTs) in order to exchange information. In addition, their approach introduces only a small overhead on the devices (routers) and therefore does not impede their normal function.

-----------------------------------------------------------------------------------
[Handover]
-----------------------------------------------------------------------------------
[243] 2017 **Follow me fog: Toward seamless handover timing schemes in a fog computing environment.**

The authors observe that traditional mobile network handover mechanisms cannot handle the demands of fog computation resources and the low-latency requirements of mobile IoT applications. The authors propose Follow Me Fog framework to guarantee service continuity and reduce latency during handovers. The key idea proposed is to continuously monitor the received signal strength of the fog nodes at the mobile IoT device, and to trigger pre-migration of computation jobs before disconnecting the IoT device from the existing fog node.

-----------------------------------------------------------------------------------
[244] 2017 **Efficient service handoff across edge servers via docker container migration.**

Present a novel service handoff system which seamlessly migrates offloading services to the nearest edge server, while the mobile client is moving. Service handoff is achieved via container migration. They have identified an important performance problem during Docker container migration, proposing a migration method which leverages the layered storage system to reduce file system synchronization overhead, without dependence on the distributed file system.

-----------------------------------------------------------------------------------
[Vehicular fog computing]
-----------------------------------------------------------------------------------
[145] 2017 **Cooperative fog computing for dealing with big data in the internet of vehicles: Architecture and hierarchical resource management**

This paper introduces the challenges of handling big data in the IoV environments. The authors emphasize on the role of fog servers and describe a regional cooperative fog computing (CFC) architecture to support IoV applications. The proposed CFC-IoV architecture consists of two layers. The fog layer is a federation of geographically distributed fog servers, a coordinator server, and the cloud servers, whereas the edge layer includes the vehicular ad hoc network (VANET), IoT applications, and mobile cellular networks.

-----------------------------------------------------------------------------------
[177] 2017 **Foud: integrating fog and cloud for 5g-enabled v2g networks**

This paper argues that cloud and fog computing using the current mobile networks may not be ideally suited to provide the desired levels of QoS for moving electric vehicles in vehicle-to-grid (V2G) services. They propose a hybrid computing model called "Foud" in which the cloud and fog come together and are made available to the V2G networks in 5G. In the proposed model, the cloud allows virtualized computing, storage, and network resources to be available to the V2G system entities, whereas the fog temporarily integrates the stationary and mobile computing resources located at the edge of V2G networks to expand the computing capacity.

-----------------------------------------------------------------------------------
[183] 2017 **Vehicular micro clouds as virtual edge servers for efficient data collection**

The concept of vehicular micro clouds based on map information is introduced, and, by a simulation study, investigated. Vehicular micro clouds are virtual edge servers and are essentially clusters of cars that help to aggregate and preprocess data that is transferred to the cloud.

-----------------------------------------------------------------------------------
2017 **Fog Vehicular Computing Augmentation of Fog Computing Using Vehicular Cloud Computing**

In accordance with the resource restrictions of fog computing, only a limited number of clients are able to use fog computing simultaneously. To alleviate this problem, they presented FVC as a new concept in which many unused resources of vehicles can be leveraged to augment fog computing resources. They also depicted the cross-layer architecture for FVC and elucidated its constitutive components along with their role in the construction of FVC.

-----------------------------------------------------------------------------------
[Others]
-----------------------------------------------------------------------------------
-----------------------------------------------------------------------------------
[143] 2018 **Virtual fog: A virtualization enabled fog computing framework for internet of things**

Jianhua Li et al. propose a layered Fog framework to better support IoT applications through virtualization. The virtualization is divided into object virtualization (VOs), network function virtualization and service virtualization. VOs to address the protocol inconsistency (lack of unified networking protocols that leads to exaggerated overhead); Network function virtualization maps standard networking services to VOs, thus, minimize the communication process between consumers and producers by minimizing latency, improving security and scalability; Service virtualization that composes the community and Cloud Apps from various vendors to serve local Fog users with high quality of experience (QoE) but at low cost. At last, Foglets are involved to seamless aggregate multiple independent virtual instances, Fog network infrastructures, and software platforms.

-----------------------------------------------------------------------------------
2018 **Dynamic Mobile Cloudlet Clustering for Fog Computing**

Fog Computing is one of the solutions for offloading the task of a mobile. However the capability of fog server is still limited due to the high deployment cost. In this paper, is proposed a dynamic mobile cloudlet cluster policy (DMCCP) to use cloudlets as a supplement for the fog server for offloading. The main idea is that by monitoring each mobile device resource amount, the DMCCP system clusters the optimal cloudlet to meet the requests of different tasks from the local mobile device.

-----------------------------------------------------------------------------------
[Introductory reference]
-----------------------------------------------------------------------------------
-----------------------------------------------------------------------------------
2017 **Fog Computing for the Internet of Mobile Things: issues and challenges**

This paper analyse what means provide mobility in Fog computing, the main challenges and three good examples where it is necessary. Also point as future work Proactive vs. reactive service migration, Exploit context information to trigger service migration, Fog federation to enable mobile roaming, Virtualization and migration techniques, Compliance with existing interoperability platforms and Integration with mobile networks towards 5G.

-----------------------------------------------------------------------------------
[261] 2017 **Virtual machine placement for backhaul traffic minimization in fog radio access networks**

How to appropriately place virtual machines (VMs) into fog nodes in F-RAN systems is very challenging, and will significantly affect the bandwidth consumption of backhaul links. Thus, Ya-Ju Yu et al. analyse the VM placement problem in fog radio access networks (F-RANs) with the objective to minimize the overall back-haul traffic. The back-haul traffic is incurred in two ways: the VM replication and data transmission to the cloud. When a user connects to a fog node and requests an application service, there is no back-haul bandwidth consumption if the fog node has the application VM. Otherwise, the VM has to be replicated on the fog node, or the request is forwarded to the cloud. They formulate the replica-based VM placement problem by considering the computing and storage of fog nodes, the user service constraint, as well as the edge bandwidth constraint.

**Note: introduction**

-----------------------------------------------------------------------------------
[Further research]
-----------------------------------------------------------------------------------
- Movable cloudlets and mobile cloudlets
- Foglets