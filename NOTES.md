Fields
----------
| Field | Report | Implemented | Notes |
| --- | :---: | :---: | :---: |
| QoS | ✓ | ✗ | - |
| QoE | ✓ | ✗ | - |
| Cost | ✓ | ✓ | - |
| Energy | ✓ | ✓ | - |
| Handover | ✓ | ✗ | - |
| Mobility | ✓ | ✓ | - |
| Bandwidth | ✓ | ✗ | - |
| Load Balancing | ✓ | ✗ | Not explicitly but, the algorithm should achieve this feature |
| Migration Optimization | ✓ | ✓ | - |
| Vehicular Fog Computing | ✓ | ✗ | Just to provide case studies |
| Predicted Mobility Patterns | ? | ? | - |
| Proactive vs. Eeactive Service Migration | ? | ? | - |
| Data placement | ✓ | ✗ | - |
| VM/Resource/Job scheduling | ✗ | - | - |
| Virtual Objects | ✓ | ✓ | - |
| Foglets | ✓ | ✓ | - |
| Toolkits | ✓ | ✓ | - |
| Data/Session Consistency | ✗ | - | - |
| VM/Resource/Job scheduling | ✗ | - | - |

- **Introduction**
	- **Motivation**
	- **Objectives**
- **Related Work**
	- **Related Computing Paradigms**
	- **Fog Computing Architecture**
			- Developing iot applications in the fog: a distributed dataflow approach (2015)
			- Incremental deployment and migration of geo-distributed situation awareness applications in the fog (2016)
			- Router-based brokering for surrogate discovery in edge computing (2017)
	- **Migration Optimization In Mobile Fog Environments**
	- **Toolkits**
- **Algorithms**
- **Architecture**
- **Evaluation**
- **Schedule of Future Work**
- **Conclusion**

Load Balancing / Resource Allocation / Data placement
----------

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

Toolkits
----------
- iFogSim: A toolkit for modeling and simulation of resource management techniques in the Internet of Things, Edge and Fog computing environments (2017)
- [385] Myifogsim: A simulator for virtual machine migration in fog computing (2017)
- [388] Edgecloudsim: An environment for performance evaluation of edge computing systems (2017)

Migration optimization in mobile fog environments
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

[Vehicular Fog Computing]
----------
[172] 2016 **Vehicular fog computing: A viewpoint of vehicles as the infrastructures.** ✓ [REPORT - MOBILE FOG COMPUTING]

Xueshi Hou et al. present the idea of utilizing vehicles as the infrastructures for communication and computation, named vehicular fog computing (VFC), which is an architecture that utilizes a collaborative multitude of end-user clients or near-user edge devices to carry out communication and computation, based on better utilization of individual communication and computational resources of each vehicle. They discussed four types of scenarios of moving and parked vehicles or congested traffic. Also, they point out the advantages against vehicular cloud computing (VCC) and the advantages in scenarios like of emergency operations for natural disaster and terrorist attack.

**Note: introduction, do not present a model, it will serve for introductory references**

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

Others
----------

[261] 2017 **Virtual machine placement for backhaul traffic minimization in fog radio access networks.** ✓

How to appropriately place virtual machines (VMs) into fog nodes in F-RAN systems is very challenging, and will significantly affect the bandwidth consumption of backhaul links. Thus, Ya-Ju Yu et al. analyse the VM placement problem in fog radio access networks (F-RANs) with the objective to minimize the overall back-haul traffic. The back-haul traffic is incurred in two ways: the VM replication and data transmission to the cloud. When a user connects to a fog node and requests an application service, there is no back-haul bandwidth consumption if the fog node has the application VM. Otherwise, the VM has to be replicated on the fog node, or the request is forwarded to the cloud. They formulate the replica-based VM placement problem by considering the computing and storage of fog nodes, the user service constraint, as well as the edge bandwidth constraint.

**Note: introduction**

[160] 2018 **Multitier fog computing with large-scale iot data analytics for smart cities.** ?

In this paper a multi tier fog computing model with large-scale data analytics service is proposed for smart cities applications. It is consisted of ad-hoc fogs and dedicated fogs with opportunistic and dedicated computing resources, respectively. They run analytics benchmark experiments over fogs formed by Raspberry Pis with a distributed computing engine to measure computing performance. QoS aware admission control, offloading, and resource allocation schemes are designed to support data analytics services, and maximize analytics service utilities. Availability and cost models of networking and computing resources are taken into account in QoS scheme design. A scalable system level simulator is developed to evaluate the fog-based analytics service and the QoS management schemes.

**Note: An early effort for mobile fog nodes**

[143] 2018 **Virtual fog: A virtualization enabled fog computing framework for internet of things.** ? (acho que não é interessante)

They propose a layered Fog framework to better support IoT applications through virtualization. The virtualization is divided into object virtualization  (VOs), network function virtualization and service virtualization. VOs to address the protocol inconsistency (lack of unified networking protocols that leads to exaggerated overhead); Network function virtualization maps standard networking services to VOs, thus, minimize the communication process between consumers and producers by minimizing latency, improving security and scalability; Service virtualization that composes the community and Cloud Apps from various vendors to serve local Fog users with high quality of experience (QoE) but at low cost. At last, Foglets are involved to seamless aggregate multiple independent virtual instances, Fog network infrastructures, and software platforms.

**Note: See again**

----------
[254] 2018 **Move with me: Scalably keeping virtual objects close to users on the move.** ? (não sei, ver melhor)

With the state-of-the-art virtualization technologies, services can be implemented in modular software as a graph/chain of portable VOs that can be dynamically migrated around the Telco infrastructure. It is proposed a VO clustering and migration policy that jointly considers user proximity and inter-VO affinity to scalably support user mobility, while allowing service differentiation among users.

Notes
----------
- Publication papers
	- IEEE infocom
	- Globecom
	- IFIP newtorking
- TODO
	- The fog layer is a federation of geographically distributed fog servers, a coordinator server, and the cloud servers,
	- check where bus papers was performed
	- organizar bibtex
	- falta paper do recap e do cloudreports
	- referencia à imagem dos paradigmas (circulos) no survey
	- capitulos todos com iniciais maiusculas
	- No final verificar todas as abreviaturas
	- Ver se na introdução nos objetivos, o multi-objective aborda todos os parametros
	- Os outros são mesmo "offline" algorithms? (energy-aware)
	- falar do loadbalancing e dizer que isto pode afetar a largura de banda (mais mensagens trocadas entre máquinas/módulos)
	- na comparacao de paradigmas, referir que o ifogsim esconde os problemas de rede, permitindo escolher o delay
	- ifogsim w/ data placement
	- falar das caracteristicas dof ifogsim e do myifogsim e falar das outras caracteristicas a implementar
	- na tabela falta ver da multi-tier application model, workload, dataplacement, bandwith
	- first fit heuristic, a genetic algorithm, and an exact optimization method (desenvolvimento)
	- fazer tabela com acronimos
	- fazer acronimo para end devices (mobile device (MD)) e end-to-end (E2E) latency
	- Load Balancing - Not explicitly but, the algorithm should achieve this feature
	- ver todas as referencias no report
- Further research
	- Movable cloudlets and mobile cloudlets
	- Bayesian optimization
	- Proactive vs reactive migration (ver tb no survey)
	- VM vs containers (ver tb no survey)
- Doubts
	- É necessário fazer referência às gateways na arquitetura? -> Assessment of the Suitability of Fog Computing in the Context of Internet of Things
	- Similar to the traditional cloud computing, fog offers tree types of service models: Software as a Service (SaaS), Platform as a Service (PaaS) and Infrastructure as a Service (IaaS) ?
	- Software-defined networking?
	- minimize the time-average cost of fog computing
	- QoS inclui limites temporais, energia, QoE e custo?
	- online vs offline algorithms ? => online heuristic and offline optimizing service orchestration method
	- Ultra Dense Networks ? => ultra-dense deployment of small cell base stations
- Not used papers
	- OpenStack extensions for QoS and energy efficiency in edge computing
	- A Game-Theoretic Approach to Coalition Formation in Fog Provider Federations
- PAPERS:
	- Cost of virtual machine live migration in clouds: A performance evaluation
	- Live virtual machine migration with adaptive, memory compression
	- Adaptive vm handoff across cloudlets
	- Particle swarm optimization for bi-level pricing problems in supply chains - pricing problems with the buyer and the vendor

Keyworks
----------
- The main reasons lie on Fig. 1
- Observe that
- As a matter of fact,
- In a nutshell,
- As we shall show,
- Aforementioned benefits
- Continuum
- We tackle the edge cloud network design problem
- Which is, to the best of our knowledge, an untreated problem in the literature
- The trend towards edge-clouds is expected
- Meanwhile, in order
- have been considered as means to provide computing capabilities
- Furthermore,
- At first sight it seems
- Ease
- It is also worth emphasizing that
- While the former ... , the latter ...

Handover
----------
[243] 2017 **Follow me fog: Toward seamless handover timing schemes in a fog computing environment.** ✓ [REPORT - HANDOVER]

The authors observe that traditional mobile network handover mechanisms cannot handle the demands of fog computation resources and the low-latency requirements of mobile IoT applications. The authors propose Follow Me Fog framework to guarantee service continuity and reduce latency during handovers. The key idea proposed is to continuously monitor the received signal strength of the fog nodes at the mobile IoT device, and to trigger pre-migration of computation jobs before disconnecting the IoT device from the existing fog node.

[DOCKER ->
- https://opensource.com/resources/what-docker
-(PODE CORRER DENTRO DE MAQUINAS VISTUAIS LINUX (DE QUALQUER DISTRIBUIÇÃO))
- Incremental deployment and migration of geo-distributed situation awareness applications in the fog
]

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

Cost
----------
- Used:
	- Efficient Placement of Multi-Component Applications in Edge Computing Systems
	- Cost efficient resource management in fog computing supported medical cyber-physical system
	- Cost Aware Service Placement and Load Dispatching in Mobile Cloud Systems
	- Optimized IoT service placement in the fog (ainda não sei se tiro este..)
	- Scalable Fog Computing with Service Offloading in Bus Networks
	- Service Entity Placement for Social Virtual Reality Applications in Edge Computing
- Could be used:
	- Asymptotically Optimal Algorithm for Online Reconfiguration of Edge-Clouds
	- Assessment of the Suitability of Fog Computing in the Context of Internet of Things
	- MOERA: Mobility-agnostic Online Resource Allocation for Edge Computing
- Not used:
	- Towards QoS-aware Fog Service Placement
	- EMM: Energy-Aware Mobility Management for Mobile Edge Computing in Ultra Dense Networks (energy-aware user-centric - acho que é para apagar)
	- Optimal Placement of Virtual Machines in Mobile Edge Computing (VRCs - acho que é para apagar)
	- A Decentralized Replica Placement Algorithm for Edge Computing (Replicas - acho que é para apagar)
	- Fog Computing Micro Datacenter Based Dynamic Resource Estimation and Pricing Model for IoT (previsão, não é sobre migração)
	- Enabling Low-Latency Applications in Fog-Radio Access Networks (não formula nada)
	- Availability-aware Mobile Edge Application Placement in 5G Networks (replicas)
	- Paying Less for More? Combo Plans for Edge-Computing Services (modelo de pagamento)
	- Fast and Efficient Network Service Embedding Method with Adaptive Offloading to the Edge (cost-aware Virtual Network Function migration)

To implement???
----------

Bandwidth
----------
- Heuristics to allocate high-performance cloudlets for computation offloading in mobile ad hoc clouds
- Virtual machine placement for backhaul traffic minimization in fog radio access networks
- Computation offloading leveraging computing resources from edge cloud and mobile peers (acho que n)
- A pso model with vm migration and transmission power control for low service delay in the multiple cloudlets ecc scenario
- Supporting Internet-of-Things Analytics in a Fog Computing Platform
- A Decentralized Replica Placement Algorithm for Edge Computing
- Improving Quality of Experience in Future Wireless Access Networks through Fog Computing
- LAVEA: Latency-aware Video Analytics on Edge Computing Platform
- Efficient Service Handoff Across Edge Servers via Docker Container Migration
- A Novel Cost Optimization Framework for MultiCloudlet Environment over Optical Access Networks
- ACACIA – Context-aware Edge Computing for Continuous Interactive Applications over Mobile Networks
- Toward Hierarchical Mobile Edge Computing: An Auction-Based Profit Maximization Approach
- PRIMAL: PRofIt Maximization Avatar pLacement for Mobile Edge Computing
- CloudFog: Leveraging Fog to Extend Cloud Gaming for Thin-Client MMOG with High Quality of Service
- Cachier: Edge-caching for recognition applications
- Foggy: a platform for workload orchestration in a Fog Computing environment
- Traffic-Aware Virtual Machine Placement in Cloudlet Mesh with Adaptive Bandwidth
- Fog Computing Through Public-Resource Computing and Storage
- Fast, scalable and secure onloading of edge functions using AirBox
- VR is on the Edge: How to Deliver 360° Videos in Mobile Networks
- Learning IoT in Edge: Deep Learning for the Internet of Things with Edge Computing
- SpanEdge: Towards Unifying Stream Processing over Central and Near-the-Edge Data Centers
- Towards Efficient Edge Cloud Augmentation for Virtual Reality MMOGs
- Low-cost Video Transcoding at the Wireless Edge
- Edgecourier: an edge-hosted personal service for low-bandwidth document synchronization in mobile cloud storage services
- MUTE: MUlti-Tier Edge networks
- ApproxIoT: Approximate Analytics for Edge Computing
- Edge Intelligence: On-Demand Deep Learning Model Co-Inference with Device-Edge Synergy
- Where’s The Bear?- Automating Wildlife Image Processing Using IoT and Edge Cloud Systems
- DeepDecision: A Mobile Deep Learning Framework for Edge Video Analytics
- Slicing WiFi WLAN-Sharing Access Infrastructures to Enhance Ultra-Dense 5G Networking
- OpenStack extensions for QoS and energy efficiency in edge computing
- Realizing the Global Edge Cloud
- Mobile-Edge Computing Versus Centralized Cloud Computing Over a Converged FiWi Access Network
- A Fog-Based Internet of Energy Architecture for Transactive Energy Management Systems
- Ensuring Reliability in Geo-Distributed Edge Cloud
- Gremlin: Scheduling Interactions in Vehicular Computing
- Fog Computing in Healthcare Internet of Things: A Case Study on ECG Feature Extraction
- Fast Transparent Virtual Machine Migration in Distributed Edge Clouds
- You Can Teach Elephants to Dance: Agile VM Handoff for Edge Computing
- Edge Computing with Cloud for Voice Disorder Assessment and Treatment

QoS
----------
124, 288, 397, 255, 231, 289, 256, 97, 72, 290, 89, 257, 126, 258, 107, 128, 380, 259, 98, 291, 130, 131, 292, 293, 260, 196, 197, 294, 295, 232, 24, 296, 297, 383, 199, 335, 210, 299, 301, 302, 211, 235, 135, 174, 175, 137, 237, 238, 262, 239, 398, 240, 263, 241, 92, 264, 303, 223, 338, 242, 177, 140, 340, 304, 305, 342, 243, 306, 244, 93, 343, 212, 91, 307, 213, 145, 179, 147, 308, 100, 267, 245, 214, 224, 90, 322, 269, 110, 246, 225, 323, 111, 403, 271, 325, 88, 215, 112, 150, 385, 386, 346, 273, 152, 309, 153, 406, 181, 348, 155, 156, 310, 407, 66, 202, 350, 351, 247, 75, 352, 353, 157, 355, 356, 311, 312, 51, 313, 158, 64, 274, 182, 409, 183, 358, 359, 249, 184, 410, 360, 159, 250, 361, 442, 390, 362, 203, 441, 412, 251, 160, 204, 363, 364, 217, 365, 413, 366, 327, 162, 218, 54, 284, 285, 367, 219, 163, 315, 316, 186, 415, 286, 164, 187, 206, 368, 166, 369, 276, 416, 167, 252, 393, 207, 277, 318, 370, 190, 372, 328, 373, 319, 168, 374, 253, 375, 278, 321, 432, 229, 417, 169, 376, 170, 220, 337, 230, 418, 192, 396, 209, 254, 122, 379, 123