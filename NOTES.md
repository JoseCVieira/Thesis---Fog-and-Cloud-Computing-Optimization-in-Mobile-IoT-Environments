Fields
----------
| Field | Address in the report | Implemented | Notes |
| --- | :---: | :---: | :---: |
| QoS | ✓ | ✗ | - |
| QoE | ✓ | ✗ | - |
| Cost | ✓ | ✗ | - |
| Energy | ✓ | ✗ | - |
| Handover | ✓ | ✗ | - |
| Mobility | ✓ | ✗ | - |
| Bandwidth | ✓ | ✗ | - |
| Migration Optimization | ✓ | ✗ | - |
| Vehicular Fog Computing | ✓ | ✗ | - |
| Data/Session Consistency | ✗ | - | - |
| VM/Resource/Job scheduling | ✗ | - | - |
| Predicted Mobility Patterns | ? | ? | - |
| Proactive vs. Eeactive Service Migration | ? | ? | - |
| Load Balancing / Resource Allocation / Data placement | ✓ | ✗ | - |
| VM/Resource/Job scheduling | ✗ | - | Not explicitly but, the algorithm should achieve this feature |
| Virtual Objects (application vs decomposition in modules) | ✓ | ✓ | - |
| Foglets | ✓ | ✓ | - |
| Toolkits | ✓ | ✓ | - |

Introduction
----------


[Load Balancing / Resource Allocation / Data placement]
----------

[197] 2016 **Incremental deployment and migration of geo-distributed situation awareness applications in the fog.** ✓ [REPORT - DATA PLACEMENT]

Enrique Saurez et al. propose Foglets, a programming model that facilitates distributed programming across fog nodes. Foglets provides APIs for spatio-temporal data abstraction for storing and retrieving application-generated data on the local nodes. Through the API, Foglets processes are set for a certain geospatial region and Foglets manages the application components on the Fog nodes. Foglets is implemented through container-based visualization. The API takes into account QoS and load balancing when migrating persistent (stateful) data between fog nodes. It provides various functionalities: automatically discovers fog computing resources deploys application components onto the fog computing resources commensurate with the latency requirements of each component in the application. It supports multi-application collocation on any compute node. Provides communication APIs for components that are deployed at different physical levels of the network hierarchy to communicate with one another to exchange application state. Lastly, it supports both latency- and workload-driven resource adaptation and state migration over space (geographic) and time to deal with the dynamism in situation awareness application.



- [325] Router-based brokering for surrogate discovery in edge computing (2017)

2015 **An architecture for Load Balancing Techniques for Fog Computing Environment.** ?

This paper **proposes a new architecture based on load balancing algorithm in Fog Computing environment. Users sent the request to the nearby Fog servers which are consistently maintaining the frequently used data. In case, the users don’t get the desired resource in nearby Fog Servers who are also communicating with each other, then that request is forwarded to the cloud servers. To implement this load balancing algorithm they use modified Honey Bee Based algorithm.**

**Note: load balancing ?**

- Nova arquitetura baseada em load balancing em fog;
- User enviam requests para o fog server mais proximo;
- Este guarda os dados mais utilizados;
- Caso não encontre pede aos outros que estão na proximidade;
- Caso não encontre, envia o request para a cloud;
- Usa o algoritmo modified Honey Bee Based.

----------
2017 **Computing Resource Allocation in Three-Tier IoT Fog Networks: A Joint Optimization Approach Combining Stackelberg Game and Matching.** ?

This paper considers a specific **fog computing network consisting of** a set of **data service operators (DSOs)** each of which controls a set of **fog nodes (FNs)** to provide the required data service to a set of **data service subscribers (DSSs).** They address the problem of **how to allocate the limited computing resources of FNs to all the DSSs to achieve an optimal and stable performance. Therefore, they propose a joint optimization in a distributed fashion. In the framework, they formulate a Stackelberg game to analyze the pricing problem for the DSOs as well as the resource allocation problem for the DSSs.**

**Note: resource allocation ?**

- Rede composta por:
- data service operators (DSOs);
- fog nodes (FNs);
- data service subscribers (DSSs);
- Pretende dar resposta ao problema de como alocar os recursos limitados dos FNs para todos os DSSs;
- Propõe joint optimization de forma distribuída;
- Formulam um Stackelberg game para analisar o problema de pricing para os DSOs e resource allocation para os DSSs.

----------
[Toolkits]
----------
----------
2017 **iFogSim: A toolkit for modeling and simulation of resource management techniques in the Internet of Things, Edge and Fog computing environments.** ✓ [REPORT - TOOLKITS]

In this paper they propose a simulator, called iFogSim, to model IoT and Fog environments and measure the impact of resource management techniques in latency, network congestion, energy consumption, and cost.

**Note: important**

----------
- [385] Myifogsim: A simulator for virtual machine migration in fog computing (2017)

----------
[388] 2017 **Edgecloudsim: An environment for performance evaluation of edge computing systems.** ? [REPORT - TOOLKITS]

The authors propose another edge computing simulation environment, EdgeCloudSim, that considers both network and computational resources and covers all aspects of edge computing simulation ,including network and computational modelling. Similar to iFogSim, EdgeCloudSim relies on CloudSim as well. Additionally, EdgeCloudSim provides a modular architecture to provide support for a variety of critical functionality and supports simulating multi-tier scenarios where multiple edge servers are running in coordination with upper layer cloud solutions.

- Possível solução?
- Edge computing simulation;
- Fornece uma arquitetura modelar;
- Suporta simulações de cenários multi-tier onde vários edge servers correm em coordenação com uma layer superior de cloud solutions.

----------
[Handover]
----------
----------
[243] 2017 **Follow me fog: Toward seamless handover timing schemes in a fog computing environment.** ✓ [REPORT - HANDOVER]

The authors observe that traditional mobile network handover mechanisms cannot handle the demands of fog computation resources and the low-latency requirements of mobile IoT applications. The authors propose Follow Me Fog framework to guarantee service continuity and reduce latency during handovers. The key idea proposed is to continuously monitor the received signal strength of the fog nodes at the mobile IoT device, and to trigger pre-migration of computation jobs before disconnecting the IoT device from the existing fog node.

----------
[244] 2017 **Efficient service handoff across edge servers via docker container migration.** ✓ [REPORT - HANDOVER]

Present a novel service handoff system which seamlessly migrates offloading services to the nearest edge server, while the mobile client is moving. Service handoff is achieved via container migration. They have identified an important performance problem during Docker container migration, proposing a migration method which leverages the layered storage system to reduce file system synchronization overhead, without dependence on the distributed file system.

----------
[300] 2017 **Emm: Energy-aware mobility management for mobile edge computing in ultra dense networks.** ? [REPORT - HANDOVER]

Develop a novel user-centric energy-aware mobility management (EMM) scheme, in order to optimize the delay, under energy consumption constraint of the user. Based on Lyapunov optimization and multi-armed bandit theories, EMM works in an online fashion. Theoretical analysis explicitly takes radio handover and computation migration cost into consideration and proves a bounded deviation on both the delay performance and energy consumption compared with the oracle solution with exact and complete future system information. The proposed algorithm also effectively handles the scenario in which candidate BSs randomly switch ON/OFF during the offloading process of a task.

----------
[285] 2018 **Mobility support for fog computing: An sdn approach.** ? [REPORT - HANDOVER]

Study of mobility support issue in fog computing for guaranteeing service continuity. Propose a novel SDN enabled architecture that is able to facilitate mobility management in fog computing by decoupling mobility management and data forwarding functions. Design an efficient handover scheme by migrating mobility management and route optimization logic to the SDN controller. By employing link layer information, the SDN controller can pre-compute the optimal path by estimating the performance gain of each path.

----------
[234] 2017 **Optimizing service replication for mobile delay-sensitive applications in 5g edge network.** ? [REPORT - HANDOVER]

To guarantee the strict latency requirements, new solutions are required to cope with the user mobility in a distributed edge cloud environment. The use of proactive replication mechanism seems promising to avoid QoE degradation during service migration between different edge nodes. However, accounting for the limited resources of edge micro data-centers, appropriate optimization solutions must be developed to reduce the cost of service deployment, while guaranteeing the desired QoE. In this paper, Ivan Farris et al., by leveraging on prediction schemes of user mobility patterns, have proposed two linear optimization solutions for replication-based service migration in cellular 5G networks: the min-RM approach aims at minimizing the QoE degradation during user handover; min-NSR approach favors the reduction of service replication cost. Simulation results proved the efficiency of each solution in achieving its design goal and provides useful information for network and service orchestrators in next-generation 5G cloud-based networks.

- Avaptive avatar handoff in the cloudlet network (2017)

----------
[Virtual Objects / Foglets]
----------
----------
[143] 2018 **Virtual fog: A virtualization enabled fog computing framework for internet of things.** ✓ [REPORT - DATA PLACEMENT]

They propose a layered Fog framework to better support IoT applications through virtualization. The virtualization is divided into object virtualization  (VOs), network function virtualization and service virtualization. VOs to address the protocol inconsistency (lack of unified networking protocols that leads to exaggerated overhead); Network function virtualization maps standard networking services to VOs, thus, minimize the communication process between consumers and producers by minimizing latency, improving security and scalability; Service virtualization that composes the community and Cloud Apps from various vendors to serve local Fog users with high quality of experience (QoE) but at low cost. At last, Foglets are involved to seamless aggregate multiple independent virtual instances, Fog network infrastructures, and software platforms.

**Note: See again**

----------
[201] 2015 **Developing iot applications in the fog: a distributed dataflow approach.** ? [REPORT - DATA PLACEMENT]

This paper proposes a Distributed Dataflow (DDF) programming model for the IoT that utilizes computing infrastructures across the Fog and the Cloud. Also, evaluate their proposal by implementing a DDF framework based on Node-RED (Distributed Node-RED or D-NR), a visual programming tool that uses a flow-based model for building IoT applications. To address challenges of the intrinsic nature of the IoT (heterogeneous devices/resources, a tightly coupled perception-action cycle and widely distributed devices and processing), they propose a Distributed Dataflow (DDF) programming model for the IoT that utilities computing infrastructures across the Fog and the Cloud. Also, they evaluate their proposal by implementing a DDF framework based on Node-RED (Distributed Node-RED or D-NR), a visual programming tool that uses a flow-based model for building IoT applications.

----------
[274] 2017 **Efficient placement of multi-component applications in edge computing systems.** ? [REPORT - DATA PLACEMENT]

The authors address the problem of multi-component application placement on fog nodes. Each application could be modeled as a graph, where each node is a component of the application, and the edges indicate the communication between them.

----------
[254] 2018 **Move with me: Scalably keeping virtual objects close to users on the move.** ? [REPORT - DATA PLACEMENT]

With the state-of-the-art virtualization technologies, services can be implemented in modular software as a graph/chain of portable VOs that can be dynamically migrated around the Telco infrastructure. It is proposed a VO clustering and migration policy that jointly considers user proximity and inter-VO affinity to scalably support user mobility, while allowing service differentiation among users.

----------
[Migration optimization in mobile fog environments]
----------
----------

- Latency-aware with mobile IoT devices
	- [237] Migcep: operator migration for mobility driven distributed complex event processing (2013)
	- [231] Dynamic service migration and workload scheduling in edge-clouds (2015)
	- [232] Segue: Quality of service aware edge cloud service migration (2016)
	- [246] Primal: Profit maximization avatar placement for mobile edge computing (2016)
	- [123] When clones flock near the fog (2018)
	- [217] Mobile edge cloud network design optimization (2017)
	- [247] Towards efficient edge cloud augmentation for virtual reality mmogs (2017)
- Latency-aware with mobile fog servers
	- Scalable Fog Computing with Service Offloading in Bus Networks (2016)


- TODO:
- Energy-aware
	- Study of migration policies in energy-aware virtual router networks - energy
	- Energy efficient vm scheduling for cloud data centers: Exact allocation and migration algorithms - energy
	- A solution of dynamic VMs placement problem for energy consumption optimization based on evolutionary game theory
	- Joint virtual machine placement and migration scheme for datacenters (energy - cloud computing)??
	- Delay-constrained hybrid computation offloading with cloud and fog computing - energy
- Others
	- Cost of virtual machine live migration in clouds: A performance evaluation
	- Live virtual machine migration with adaptive, memory compression
	- Adaptive vm handoff across cloudlets
	- Particle swarm optimization for bi-level pricing problems in supply chains - pricing problems with the buyer and the vendor

----------
[Mobility]
----------
----------
[172] 2016 **Vehicular fog computing: A viewpoint of vehicles as the infrastructures.** ✓ [REPORT - MOBILE FOG COMPUTING]

Xueshi Hou et al. present the idea of utilizing vehicles as the infrastructures for communication and computation, named vehicular fog computing (VFC), which is an architecture that utilizes a collaborative multitude of end-user clients or near-user edge devices to carry out communication and computation, based on better utilization of individual communication and computational resources of each vehicle. They discussed four types of scenarios of moving and parked vehicles or congested traffic. Also, they point out the advantages against vehicular cloud computing (VCC) and the advantages in scenarios like of emergency operations for natural disaster and terrorist attack.

**Note: introduction, do not present a model, it will serve for introductory references**

----------
[186] 2018 **Mobile edge computing via a uav-mounted cloudlet: Optimization of bit allocation and path planning.** ✓ [REPORT - MOBILE FOG COMPUTING]

Unmanned aerial vehicles (UAVs) have been considered as means to provide computing capabilities. In this model, UAVs act as fog nodes and provide computing capabilities with enhanced coverage for IoT nodes. The system aims at minimizing the total mobile energy consumption while satisfying QoS requirements of the offloaded mobile application. This architecture is based on a UAV-mounted cloudlet which provides the offloading opportunities to multiple static mobile devices. They aim to minimize the mobile energy consumption, while satisfying QoS requirements and optimize UAV’s trajectory.

**Note: introduction, presents a energetic model, will serve for introductory references**

----------
[270] 2016 **An adaptive cloudlet placement method for mobile applications over gps big data.** ✓ [REPORT - MOBILE FOG COMPUTING]

Introduces the concept of movable cloudlets and explores the problem of how to cost-effectively deploy these movable cloudlets to enhance cloud services for dynamic context-aware mobile applications. To this end, Haolong Xiang et al. propose an adaptive cloudlet placement (via GPS) method for mobile applications. Specifically, the gathering regions of the mobile devices are identified based on position clustering, and the cloudlet destination locations are confirmed accordingly. Besides, the traces between the origin and destination locations of these mobile cloudlets are also achieved.

**Note: introduction, important?**

----------
2018 **Dynamic Mobile Cloudlet Clustering for Fog Computing.** ✓ [REPORT - MOBILE FOG COMPUTING]

Fog Computing is one of the solutions for offloading the task of a mobile. However the capability of fog server is still limited due to the high deployment cost. In this paper, is proposed a dynamic mobile cloudlet cluster policy (DMCCP) to use cloudlets as a supplement for the fog server for offloading. The main idea is that by monitoring each mobile device resource amount, the DMCCP system clusters the optimal cloudlet to meet the requests of different tasks from the local mobile device.

----------
[Vehicular Fog Computing]
----------
----------
[145] 2017 **Cooperative fog computing for dealing with big data in the internet of vehicles: Architecture and hierarchical resource management.** ? 

This paper introduces the challenges of handling big data in the IoV environments. The authors emphasize on the role of fog servers and describe a regional cooperative fog computing (CFC) architecture to support IoV applications. The proposed CFC-IoV architecture consists of two layers. The fog layer is a federation of geographically distributed fog servers, a coordinator server, and the cloud servers, whereas the edge layer includes the vehicular ad hoc network (VANET), IoT applications, and mobile cellular networks.

**Note: See again**

----------
[177] 2017 **Foud: integrating fog and cloud for 5g-enabled v2g networks.** ?

This paper argues that cloud and fog computing using the current mobile networks may not be ideally suited to provide the desired levels of QoS for moving electric vehicles in vehicle-to-grid (V2G) services. They propose a hybrid computing model called "Foud" in which the cloud and fog come together and are made available to the V2G networks in 5G. In the proposed model, the cloud allows virtualized computing, storage, and network resources to be available to the V2G system entities, whereas the fog temporarily integrates the stationary and mobile computing resources located at the edge of V2G networks to expand the computing capacity.

**Note: See again**

----------
[183] 2017 **Vehicular micro clouds as virtual edge servers for efficient data collection.** ?

The concept of vehicular micro clouds based on map information is introduced, and, by a simulation study, investigated. Vehicular micro clouds are virtual edge servers and are essentially clusters of cars that help to aggregate and preprocess data that is transferred to the cloud.

**Note: See again**

----------
2017 **Fog Vehicular Computing Augmentation of Fog Computing Using Vehicular Cloud Computing.** ?

In accordance with the resource restrictions of fog computing, only a limited number of clients are able to use fog computing simultaneously. To alleviate this problem, they presented FVC as a new concept in which many unused resources of vehicles can be leveraged to augment fog computing resources. They also depicted the cross-layer architecture for FVC and elucidated its constitutive components along with their role in the construction of FVC.

**Note: See again**

----------
[149] 2018 **Toward efficient content delivery for automated driving services: An edge computing solution.** ?

They propose a two-level edge computing architecture for automated driving services in order to make full use of the intelligence at the wireless edge (i.e., base stations and autonomous vehicles) for coordinated content delivery. Then they investigate the research challenges of wireless edge caching and vehicular content sharing. Finally, they propose potential solutions to these challenges and evaluate them using real and synthetic traces.

**Note: See again**

----------
[Introductory reference]
----------
----------
2017 **Fog Computing for the Internet of Mobile Things: issues and challenges.** ✓

This paper analyse what means provide mobility in Fog computing, the main challanges and three good examples where it is necessary. Also point as future work Proactive vs. reactive service migration, Exploit context information to trigger service migration, Fog federation to enable mobile roaming, Virtualization and migration techniques, Compliance with existing interoperability platforms and Integration with mobile networks towards 5G.

**Note: introductory reference**

----------
[261] 2017 **Virtual machine placement for backhaul traffic minimization in fog radio access networks.** ✓

How to appropriately place virtual machines (VMs) into fog nodes in F-RAN systems is very challenging, and will significantly affect the bandwidth consumption of backhaul links. Thus, Ya-Ju Yu et al. analyse the VM placement problem in fog radio access networks (F-RANs) with the objective to minimize the overall back-haul traffic. The back-haul traffic is incurred in two ways: the VM replication and data transmission to the cloud. When a user connects to a fog node and requests an application service, there is no back-haul bandwidth consumption if the fog node has the application VM. Otherwise, the VM has to be replicated on the fog node, or the request is forwarded to the cloud. They formulate the replica-based VM placement problem by considering the computing and storage of fog nodes, the user service constraint, as well as the edge bandwidth constraint.

**Note: introduction**

----------
[Others]
----------
----------
[160] 2018 **Multitier fog computing with large-scale iot data analytics for smart cities.** ?

In this paper a multi tier fog computing model with large-scale data analytics service is proposed for smart cities applications. It is consisted of ad-hoc fogs and dedicated fogs with opportunistic and dedicated computing resources, respectively. They run analytics benchmark experiments over fogs formed by Raspberry Pis with a distributed computing engine to measure computing performance. QoS aware admission control, offloading, and resource allocation schemes are designed to support data analytics services, and maximize analytics service utilities. Availability and cost models of networking and computing resources are taken into account in QoS scheme design. A scalable system level simulator is developed to evaluate the fog-based analytics service and the QoS management schemes.

**Note: An early effort for mobile fog nodes**

----------
----------
[QoS]
----------
----------
----------
[QoE]
----------
----------
----------
[Cost]
----------
----------
----------
[Energy]
----------
----------
----------
[Bandwidth]
----------
----------
----------
[Further research]
----------
- Movable cloudlets and mobile cloudlets
- Foglets
- Bayesian optimization
- fog architecture
- falta chapters dos algoritmos de optimização
- No final verificar todas as abreviaturas

IEEE infocom
Globecom
IFIP newtorking

The fog layer is a federation of geographically distributed fog servers, a coordinator server, and the cloud servers,
check where bus papers was performed

organizar bibtex
falta paper do recap e do cloudreports
referencia à imagem dos paradigmas (circulos) no survey
capitulos todos com iniciais maiusculas