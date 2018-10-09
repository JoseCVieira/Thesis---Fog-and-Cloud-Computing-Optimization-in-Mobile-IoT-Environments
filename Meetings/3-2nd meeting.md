**All One Needs to Know about Fog Computing and Related Edge Computing Paradigms: A Complete Survey**

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

TODO:
corretor ortografico
verificar por "we" ou "our"
verificar novamente os que têm ✓

1 - PAPERS - MOBILITY

-----------------------------------------------------------------------------------
[27] ✗

Mugen Peng, Shi Yan, Kecheng Zhang, and Chonggang Wang. **Fog-computing-based
radio access networks: issues and challenges.** IEEE Network, 30(4):46–53, 2016.

In C-RAN a large number of low-cost Remote Radio Heads (RRHs) are randomly deployed 
and connected to the Base Band Unit (BBU) pool through the front-haul links. Both
F-RAN and C-RAN are suited for mobile networks with base stations and are candidates
for 5G deployments. Also, the use of F-RAN and C-RAN brings a more energy efficient
form of network operation. We encourage the motivated reader to refer to reference
[27] for more information about F-RAN.

-----------------------------------------------------------------------------------
[54] ✓

Yong Cui, Jian Song, Kui Ren, Minming Li, Zongpeng Li, Qingmei Ren, and
Yangjun Zhang. **Software defined cooperative offloading for mobile cloudlets.**
IEEE/ACM Transactions on Networking, 25(3):1746–1760, 2017.

The concept of mobile cloudlets is similar to cloudlets, in which the cloudlets are a
group of nearby mobile devices that are connected wirelessly, e.g., using WiFi or
Bluetooth [54]. In mobile cloudlets, mobile devices can be providers as well as
clients of computing service.

-----------------------------------------------------------------------------------
[97] ✓

Marcelo Yannuzzi, R Milito, René Serral-Gracià, D Montero, and Mario Nemirovsky.
**Key ingredients in an iot recipe: Fog computing, cloud computing,
and more fog computing.** In Computer Aided Modeling and Design of Communication
Links and Networks (CAMAD), 2014 IEEE 19th International Workshop on,
pages 325–329. IEEE, 2014.

This paper analysis is particularly centered on mobility, reliable control and actuation
and scalability requirements, especially, in IoT scenarios that span large geographical
areas and require real-time decisions based on data analytics. They expose the reasons
why Fog Computing is the natural platform for IoT, and discuss the unavoidable interplay
of the Fog and the Cloud (for an adaptable and scalable platform for IoT) in the coming
years. They show that as long as the technological requirements and constraints of the IoT
applications are properly fulfilled, it is up to the platform designer to decide whether
an endpoint should be served by the Cloud, the Fog, or an adequate combination of the two
at any given time during the service lifetime.

Resumo: Fala sobre os requisitos de mobilidade, controlo e atuação fiáveis e escalabilidade
em cenários IoT em tempo real e grandes áreas geográficas. Mostram que fog computing é a
plataforma natural para IoT a imprescindível interação entre fog e cloud. Mostram que desde
que as restrições sejam cumpridas, cabe ao platform designer decidir quando um disp. IoT deve
ser servido pela cloud, fog ou por uma combinação dos dois.

-----------------------------------------------------------------------------------
[112] ✗

Ivan Farris, Roberto Girau, Leonardo Militano, Michele Nitti, Luigi Atzori, Antonio
Iera, and Giacomo Morabito. **Social virtual objects in the edge cloud.** IEEE
Cloud Computing, 2(6):20–28, 2015.

Propose adopting edge cloud technologies in the implementation of the SIoT platform.
Present the changes introduced in a traditional cloud-platform-based implementation
of the SIoT solution, consequent to the use of edge cloud technologies, which must
be able to detect the need for a change in the geographical location of the virtual
object and to handle the intercloud mobility of related processes and data. Analysis
of a use case demonstrates the need for our proposed solution and demonstrates its
advantages.

-----------------------------------------------------------------------------------
[116] ✗

Yotam Harchol, Aisha Mushtaq, James McCauley, Aurojit Panda, and Scott
Shenker. **Cessna: Resilient edge-computing.** In Proceedings of the 2018 Workshop
on Mobile Edge Communications, pages 1–6. ACM, 2018.

By offloading computation from clients and/or servers to the edge, is obtained a latency
reduction, backbone bandwidth and computational requirements on clients, however, it
raises the question of how one can design such a client-edge-server system to tolerate
edge failures and client mobility. The key challenge is to ensure correctness when the
edge processing is stateful. They propose an initial design for meeting this challenge
Client-Edge-Server for Stateful Network Applications (CESSNA).

-----------------------------------------------------------------------------------
[123] ✓

Sherif Abdelwahab, Sophia Zhang, Ashley Greenacre, Kai Ovesen, Kevin
Bergman, and Bechir Hamdaoui. **When clones flock near the fog.** IEEE Internet
of Things Journal, 2018.

They design self-deploying brokering clones that discover cloud/edge hosting platforms and
autonomously migrate clones between them according to self-measured weighted tail end-to-end
latency without the need of a central monitoring and control unit, not having to sacrifice
computation offloading gain in cloud platforms. Finally, it is simple and requires no change
in existing cloud platforms controllers.

-----------------------------------------------------------------------------------
[130]

Kai Liang, Liqiang Zhao, Xiaoli Chu, and Hsiao-Hwa Chen. **An integrated
architecture for software defined and virtualized radio access networks with
fog computing.** IEEE Network, 31(1):80–87, 2017.

Fog networks can be implemented by SDN and virtualization to
reduce the management costs, and to improve the scalability and
resource utilization. The authors in [130] propose an integrated
network architecture for software-defined and virtualized radio
access networks with fog computing. The proposed architecture
is hierarchical and has two control levels: the higher level that is
the SDN controller and the lower layer that is the local controller,
which could be collocated with fog nodes. The SDN controller
instructs the local controllers how to process specific applications
or requests. The authors further introduce a SaaS called OpenPine
that enables virtualization at the network level and user control of
network operation.

As redes fog podem ser implementadas por SDN (software defined networking) e por
virtualização para reduzir os management costs e melhorar a escalabilidade e a
utilização de recursos. Os autores propõem uma arquitetura de rede integrada para
software-defined e virtualized radio access networks com fog computing. A
arquitetura proposta é hierárquica e possui dois níveis de controlo: o nível superior
que é o controlador SDN e a layer inferior que é o controlador local, que pode ser
colocado com junto aos fog nodes. O controlador SDN instrui os controladores locais
sobre como processar aplicações específicas ou requests. Os autores ainda introduzem
um SaaS chamado OpenPine, que permite a virtualização ao nível da rede e user control
sobre a operação da rede.

-----------------------------------------------------------------------------------
[143] ✓

Jianhua Li, Jiong Jin, Dong Yuan, and Hongke Zhang. **Virtual fog: A virtualization
enabled fog computing framework for internet of things.** IEEE Internet of
Things Journal, 5(1):121–131, 2018.

Propose a layered Fog framework to better support IoT applications through virtualization.
The virtualization is divided into object virtualization (VOs) to address the protocol
inconsistency (lack of unified networking protocols -> exaggerate the overhead), network
function virtualization maps standard networking services to VOs, thus, minimize the
communication process between consumers and producers by minimizing latency, improving
security and scalability, and service virtualization that composes the community and
Cloud Apps from various vendors to serve local Fog users with high quality of experience
(QoE) but at low cost. At last, Foglets are involved to seamless aggregate multiple
independent virtual instances, Fog network infrastructures, and software platforms.

-----------------------------------------------------------------------------------
[145] ✗

Wenyu Zhang, Zhenjiang Zhang, and Han-Chieh Chao. **Cooperative fog computing
for dealing with big data in the internet of vehicles: Architecture and
hierarchical resource management.** IEEE Communications Magazine, 55(12):
60–67, 2017.

The paper introduces the challenges of handling big data in the IoV environments. The
authors emphasize on the role of fog servers and describe a regional cooperative fog
computing (CFC) architecture to support IoV applications. The proposed CFC-IoV
architecture consists of two layers - the fog layer and edge layer. The fog layer is
a federation of geographically distributed fog servers, a coordinator server, and the 
cloud servers, whereas the edge layer includes the vehicular ad hoc network (VANET),
IoT applications, and mobile cellular networks.

-----------------------------------------------------------------------------------
[146] ✗

H. Zhang, Y. Qiu, X. Chu, K. Long, and V. C. M. Leung. **Fog radio access networks:
Mobility management, interference mitigation, and resource optimization.** IEEE
Wireless Communications, 24(6):120–127, Dec 2017.

They focuses on interference mitigation, resource optimization, and mobility management
in F-RAN. The authors first present the system architecture that illustrates how the
various components in F-RAN, such as macro RRHs (MRRHs), small RRHs (SRRHs), fog
computing access points (F-APs), and smart user equipment (F-UE), work together for the
successful implementation of F-RAN. The MRRHs, SRRHs and the F-APs connect to the BBU
pool which supports resource optimization and provides centralized storage and
communications in F-RAN.

-----------------------------------------------------------------------------------
[149] ✗

Quan Yuan, Haibo Zhou, Jinglin Li, Zhihan Liu, Fangchun Yang, and
Xuemin Sherman Shen. **Toward efficient content delivery for automated driving
services: An edge computing solution.** IEEE Network, 32(1):80–86, 2018.

They propose a two-level edge computing architecture for automated driving services in
order to make full use of the intelligence at the wireless edge (i.e., base stations
and autonomous vehicles) for coordinated content delivery. We then investigate the
research challenges of wireless edge caching and vehicular content sharing. Finally,
we propose potential solutions to these challenges and evaluate them using real and
synthetic traces. Simulation results demonstrate that the proposed solutions can
significantly reduce the backhaul and wireless bottlenecks of cellular networks while
ensuring the quality of automated driving services.

-----------------------------------------------------------------------------------
[152] ✗

Cesar A Garcia-Perez and Pedro Merino. **Enabling low latency services on lte
networks.** In Foundations and Applications of Self* Systems, IEEE International
Workshops on, pages 248–255. IEEE, 2016.

In this paper, they propose an LTE compliant architecture to reduce latency for some
scenarios combining FOG, MEC and SDN. Our aim is to modify the behavior of the General
Packet Radio Service (GPRS) Tunneling Protocol (GTP) tunnels to analyze the traffic in
order to decide on further optimizations, for example to implement a kind of device-to-device
communication for some services.

-----------------------------------------------------------------------------------
[160] ✗ ?

J. He, J. Wei, K. Chen, Z. Tang, Y. Zhou, and Y. Zhang. **Multitier fog computing
with large-scale iot data analytics for smart cities.** IEEE Internet of Things Journal,
5(2):677–686, April 2018.

In this paper a multitier fog computing model with large-scale data analytics service
is proposed for smart cities applications. The multitier fog is consisted of ad-hoc
fogs and dedicated fogs with opportunistic and dedicated computing resources, respectively.
They run analytics benchmark experiments over fogs formed by Rapsberry Pis with a distributed
computing engine to measure computing performance. QoS aware admission control, offloading,
and resource allocation schemes are designed to support data analytics services, and maximize
analytics service utilities. Availability and cost models of networking and computing resources
are taken into account in QoS scheme design. A scalable system level simulator is developed to
evaluate the fog-based analytics service and the QoS management schemes.

-----------------------------------------------------------------------------------
[172] ✓

Xueshi Hou, Yong Li, Min Chen, DiWu, Depeng Jin, and Sheng Chen. **Vehicular
fog computing: A viewpoint of vehicles as the infrastructures.** IEEE Transactions
on Vehicular Technology, 65(6):3860–3873, 2016.

Surge na secção Support of High-speed Users no trabalha futuro apontado pelo servey.
Apresenta a ideia de vehicular fog computing (VFC) utilizando veículos com infraestrutura
de comunicação e computação. O VFC aproveita um grupo dinâmico de veículos para ajudar a
aumentar o poder computacional e diminuir os problemas de latência. De forma diferente da
vehicular cloud computing, o VFC suporta geodistribuição, tomada de decisão local e
real-time load-balancing. Além disso, o VFC depende da colaboração de veículos próximos,
em vez de depender dos servidores remotos, o que reduz os custos de implantação e o atraso.

This paper presents the idea of utilizing vehicles as the infrastructures for communication
and computation, named vehicular fog computing (VFC), which is an architecture that utilizes
a collaborative multitude of end-user clients or near-user edge devices to carry out
communication and computation, based on better utilization of individual communication and
computational resources of each vehicle. By aggregating abundant resources of individual
vehicles, the quality of services and applications can be enhanced greatly. In particular,
by discussing four types of scenarios of moving and parked vehicles as the communication and
computational infrastructures, we carry on a quantitative analysis of the capacities of VFC.
We unveil an interesting relationship among the communication capability, connectivity,
and mobility of vehicles, and we also find out the characteristics about the pattern
of parking behavior, which benefits from the understanding of utilizing the vehicular
resources. Finally, we discuss the challenges and open problems in implementing the proposed
VFC system as the infrastructures.

-----------------------------------------------------------------------------------
[175] ✗

I Farris, A Orsino, L Militano, Michele Nitti, Giuseppe Araniti, Luigi Atzori, and
Antonio Iera. **Federations of connected things for delay-sensitive iot services in
5g environments.** In Communications (ICC), 2017 IEEE International Conference
on, pages 1–6. IEEE, 2017.

This study looks at the latency issues that may be experienced by delay-sensitive IoT
applications due to the geographical distances between the physical IoT devices and
the data centers. The authors consider the mobile IoT federation as a service (MIFaaS)
paradigm that leverages the pool of devices managed by individual cloud providers as a
whole in order to help support delay-sensitive applications. The network model considered
is a cellular IoT environment with multiple LTE femtocells as the network edge nodes that
supports the MIFaaS paradigm.

-----------------------------------------------------------------------------------
[177] ✗

Ming Tao, Kaoru Ota, and Mianxiong Dong. **Foud: integrating fog and cloud
for 5g-enabled v2g networks.** IEEE Network, 31(2):8–13, 2017.

This paper argues that cloud and fog computing using the current mobile networks may
not be ideally suited to provide the desired levels of QoS for moving electric vehicles
in vehicle-to-grid (V2G) services. They propose a hybrid computing model called "Foud"
in which the cloud and fog come together and are made available to the V2G networks in
5G. In the proposed model, the cloud allows virtualized computing, storage, and network
resources to be available to the V2G system entities, whereas the fog temporarily
integrates the stationary and mobile computing resources located at the edge of V2G
networks to expand the computing capacity.

-----------------------------------------------------------------------------------
[183] ✗

Florian Hagenauer, Christoph Sommer, Takamasa Higuchi, Onur Altintas, and
Falko Dressler. **Vehicular micro clouds as virtual edge servers for efficient
data collection.** In 23rd ACM International Conference on Mobile Computing
and Networking (MobiCom 2017), 2nd ACM International Workshop on Smart,
Autonomous, and Connected Vehicular Systems and Services (CarSys 2017), 2017.

The concept of vehicular micro clouds based on map information is introduced, and, by
a simulation study, investigated. Vehicular micro clouds are virtual edge servers and
are essentially clusters of cars that help to aggregate and preprocess data that is
transferred to the cloud.

-----------------------------------------------------------------------------------
[185] ✗

Paolo Bellavista, Stefano Chessa, Luca Foschini, Leo Gioia, and Michele Girolami.
**Human-enabled edge computing: Exploiting the crowd as a dynamic extension
of mobile edge computing.** IEEE Communications Magazine, 56(1):145–155, 2018.

The authors propose human-driven edge computing (HEC) as a new model to ease the
provisioning and to extend the coverage of traditional fixed MEC solutions by
utilizing devices that humans carry.

-----------------------------------------------------------------------------------
[186] ✗

Seongah Jeong, Osvaldo Simeone, and Joonhyuk Kang. **Mobile edge computing
via a uav-mounted cloudlet: Optimization of bit allocation and path planning.**
IEEE Transactions on Vehicular Technology, 67(3):2049–2063, 2018.

Unmanned aerial vehicles (UAVs) have been considered as means to provide computing
capabilities. In this model, UAVs act as fog nodes and provide computing capabilities
with enhanced coverage for IoT nodes. The system aims at minimizing the total mobile
energy consumption while satisfying QoS requirements of the offloaded mobile application.
This architecture is based on a UAV-mounted cloudlet which provides the offloading
opportunities to multiple static mobile devices. They aim to minimize the mobile energy
and optimize UAV’s trajectory.

-----------------------------------------------------------------------------------
[197] ✓

Enrique Saurez, Kirak Hong, Dave Lillethun, Umakishore Ramachandran, and
Beate Ottenwälder. **Incremental deployment and migration of geo-distributed
situation awareness applications in the fog.** In Proceedings of the 10th ACM
International Conference on Distributed and Event-based Systems, pages 258–269.
ACM, 2016.

They propose Foglets, a programming model that facilitates distributed programming
across fog nodes. Foglets provides APIs for spatio-temporal data abstraction for
storing and retrieving application-generated data on the local nodes. Through the
Foglets API, Foglets processes are set for a certain geospatial region and Foglets
manages the application components on the Fog nodes. Foglets is implemented through
container-based visualization. The Foglets API takes into account QoS and load balancing
when migrating persistent (stateful) data between fog nodes.

-----------------------------------------------------------------------------------
[201] ✗

Nam Ky Giang, Michael Blackstock, Rodger Lea, and Victor CM Leung. **Developing
iot applications in the fog: a distributed dataflow approach.** In Internet
of Things (IOT), 2015 5th International Conference on the, pages 155–162. IEEE,
2015.

This paper propose a Distributed Dataflow (DDF) programming model for the IoT that
utilises computing infrastructures across the Fog and the Cloud. Also, evaluate their
proposal by implementing a DDF framework based on Node-RED (Distributed Node-RED or
D-NR), a visual programming tool that uses a flow-based model for building IoT
applications. Via demonstrations, they show that this approach eases the development
process and can be used to build a variety of IoT applications that work efficiently
in the Fog.

-----------------------------------------------------------------------------------
[205] ✗

Taeyeol Jeong, Jaeyoon Chung, James Won-Ki Hong, and Sangtae Ha. **Towards
a distributed computing framework for fog.** In Fog World Congress (FWC), 2017
IEEE, pages 1–6. IEEE, 2017.

This paper presents Crystal, a distributed computing framework for fog. An application
consisting of one or multiple Crystal instances offers distributed processing and
computing while taking advantage of location transparency, self-healing, auto-scaling
and mobility support. This prototype implementation of MapReduce on Crystal shows
benefits of fog computing – fault-tolerant distributed processing over heterogeneous,
unreliable, fog nodes while reducing overall latency, thanks to the framework enabling
processing close to the data source.

-----------------------------------------------------------------------------------
[210] ✗

Qiang Fan and Nirwan Ansari. **Cost aware cloudlet placement for big data processing
at the edge.** In Communications (ICC), 2017 IEEE International Conference
on, pages 1–6. IEEE, 2017.

Address the problem of placing the cloudlets to minimize the deployment cost of cloudlet
providers and to minimize the endto- end delay of user requests. Since the total deployment
cost of a cloudlet provider depends on the location of cloudlets and the amount of resources
for cloudlets, cloudlet providers must take into account both the end-to-end delay of user
requests and the deployment cost.

-----------------------------------------------------------------------------------
[217] ✓

Alberto Ceselli, Marco Premoli, and Stefano Secci. **Mobile edge cloud network
design optimization.** IEEE/ACM Transactions on Networking, 25(3):1818–1831,
2017.

This paper presents link-path formulations supported by heuristics to compute solutions
in reasonable time. Qualify the advantage in considering mobility for both users and VMs.
Compare two VM mobility modes, determining that high preference should be given to live
migration and bulk migration seem to be a feasible alternative on delay-stringent tiny-disk
services, such as augmented reality support, and only with further relaxation on network
constraints. Also they focus on the potential medium-term planning of an edge cloud network
in mobile access networks. They study two design cases: 1) network in a static state
2) network state variations in terms of load and service level, caused by user mobility.

-----------------------------------------------------------------------------------
[226] ✗

Chanh Nguyen Le Tan, Cristian Klein, and Erik Elmroth. **Location-aware load
prediction in edge data centers.** In Fog and Mobile Edge Computing (FMEC), 2017
Second International Conference on, pages 25–31. IEEE, 2017.

A location-aware load prediction for edge data centers is proposed. For each edge data
center, the load is predicted using its historical load time series and those of its
neighboring data centers.

-----------------------------------------------------------------------------------
[231] ✓

Rahul Urgaonkar, Shiqiang Wang, Ting He, Murtaza Zafer, Kevin Chan, and
Kin K Leung. **Dynamic service migration and workload scheduling in edge-clouds.**
Performance Evaluation, 91:205–228, 2015.

This paper presents a model to optimize operational costs while providing rigorous
performance guarantees as a sequential decision making Markov Decision Problem (MDP).
This model is different from the traditional solution methods (such as dynamic
programming) that require extensive statistical knowledge and are computationally
prohibitive. First they establish a decoupling property of the MDP that reduces it to
two independent MDPs. Then, using the technique of Lyapunov optimization over renewals
they design an online control algorithm that is provably cost-optimal.

-----------------------------------------------------------------------------------
[232] ✓

Wuyang Zhang, Yi Hu, Yanyong Zhang, and Dipankar Raychaudhuri. **Segue:
Quality of service aware edge cloud service migration.** In Cloud Computing
Technology and Science (CloudCom), 2016 IEEE International Conference on, pages
344–351. IEEE, 2016.

This paper propose SEGUE, a service that achieves optimal migration decisions by providing
a long-term optimal QoS to mobile users. This model arise to overcome the limitations of
previous studies that propose a distance-based Markov Decision Process (MDP) for optimizing
migration decisions that fails to consider dynamic network and server states. SEGUE is a
MDP-based model which incorporates the two dominant factors in making migration decisions:
1) network state, and 2) server state. They used an augmented reality application to evaluate
the performance where the obtained results show that it reduces the response time by 27.21%
and 53.70% compared to the lowest load migration model and the least hop migration model,
respectively. As future work they pointed a experimental proof-of-concept validation and
also evaluate the resource cost of this proposed system.

-----------------------------------------------------------------------------------
[234] ✓

Ivan Farris, Tarik Taleb, Miloud Bagaa, and Hannu Flick. **Optimizing service
replication for mobile delay-sensitive applications in 5g edge network.** In
Communications (ICC), 2017 IEEE International Conference on, pages 1–6. IEEE,
2017.

Define two integer linear programming (ILP) optimization schemes to minimize QoE
degradation and cost of replica deployment in service replication for MEC. They
distinguish classic reactive service migration from proactive migration: reactive
service migration is dependent on user movement and accommodates this movement by
locating the most suitable target edge and then starting the process for migration;
however, proactive service migration deploys multiple replicas of the user service
to neighboring nodes. As a future direction, one could study path-oriented proactive
migration and trade-offs between the probability of reactive migration and the cost
of service replications.

-----------------------------------------------------------------------------------
[237] ✓

Beate Ottenwälder, Boris Koldehofe, Kurt Rothermel, and Umakishore Ramachandran.
**Migcep: operator migration for mobility driven distributed complex
event processing.** In Proceedings of the 7th ACM international conference on
Distributed event-based systems, pages 183–194. ACM, 2013.

This paper presents a placement and migration method for providers of infrastructures
that incorporate cloud and fog resources. It ensures application-defined end-to-end
latency restrictions and reduces the network utilization by planning the migration ahead
of time. Furthermore, present how the application knowledge of the CEP system can be
used to improve current live migration techniques for Virtual Machines (VMs) to reduce
the required bandwidth during the migration. Our evaluations show that we safe up to 49%
of the network utilization with perfect knowledge about a users mobility pattern and up
to 27% of the network utilization when considering the uncertainty of those patterns.

-----------------------------------------------------------------------------------
[238] ✗

Nam Ky Giang, Michael Blackstock, Rodger Lea, and Victor CM Leung. **Developing
iot applications in the fog: a distributed dataflow approach.** In Internet
of Things (IOT), 2015 5th International Conference on the, pages 155–162. IEEE,
2015.

To address challenges of the intrinsic nature of the IoT (heterogeneous devices/resources,
a tightly coupled perception-action cycle and widely distributed devices and processing),
they propose a Distributed Dataflow (DDF) programming model for the IoT that utilises
computing infrastructures across the Fog and the Cloud. Also, they evaluate their proposal by
implementing a DDF framework based on Node-RED (Distributed Node-RED or D-NR), a visual
programming tool that uses a flow-based model for building IoT applications. Demonstrations
show that this approach eases the development process and can be used to build a variety of
IoT applications that work efficiently in the Fog.

-----------------------------------------------------------------------------------
[243] ✗ ?

Wei Bao, Dong Yuan, Zhengjie Yang, Shen Wang, Wei Li, Bing Bing Zhou, and
Albert Y Zomaya. **Follow me fog: Toward seamless handover timing schemes
in a fog computing environment.** IEEE Communications Magazine, 55(11):72–78,
2017.

The authors in observe that traditional mobile network handover mechanisms cannot handle
the demands of fog computation resources and the low-latency requirements of mobile IoT
applications. The authors propose Follow Me Fog framework to guarantee service continuity
and reduce latency during handovers. The key idea proposed is to continuously monitor the
received signal strength of the fog nodes at the mobile IoT device, and to trigger
pre-migration of computation jobs before disconnecting the IoT device from the existing
fog node.

-----------------------------------------------------------------------------------
[244] ✗

Lele Ma, Shanhe Yi, and Qun Li. **Efficient service handoff across edge servers via
docker container migration.** In Proceedings of the Second ACM/IEEE Symposium
on Edge Computing, page 11. ACM, 2017.

Present a novel service handoff system which seamlessly migrates offloading services
to the nearest edge server, while the mobile client is moving. Service handoff is
achieved via container migration. They have identified an important performance problem
during Docker container migration, proposing a migration method which leverages the
layered storage system to reduce file system synchronization overhead, without
dependence on the distributed file system. An implementation using real world product
applications, shows that compared to state-of-the-art service handoff systems designed
for edge computing platforms, their system reduces the total duration of service handoff
time by 80%(56%) with network bandwidth 5Mbps(20Mbps).

-----------------------------------------------------------------------------------
[246] ✓

Xiang Sun and Nirwan Ansari. **Primal: Profit maximization avatar placement
for mobile edge computing.** In Communications (ICC), 2016 IEEE International
Conference on, pages 1–6. IEEE, 2016.

end-to-end (E2E)
User Equipment (UE)
Avatar -> a software clone located in a cloudlet

By considering the gain (i.e., the E2E delay reduction) and the cost (i.e., the migration
overheads) of the live Avatar migration, we propose a PRofIt Maximization Avatar pLacement
(PRIMAL) strategy for the cloudlet network in order to optimize the tradeoff between the
migration gain and the migration cost by selectively migrating the Avatars to their optimal
locations. Simulation results demonstrate that as compared to the other two strategies (i.e.,
Follow Me Avatar and Static), PRIMAL maximizes the profit in terms of maintaining the low
average E2E delay between UEs and their Avatars and minimizing the migration cost
simultaneously.

-----------------------------------------------------------------------------------
[247] ✓ ?

Wuyang Zhang, Jiachen Chen, Yanyong Zhang, and Dipankar Raychaudhuri.
**Towards efficient edge cloud augmentation for virtual reality mmogs.** In Proceedings
of the Second ACM/IEEE Symposium on Edge Computing, page 8. ACM,
2017.

Propose a hybrid gaming architecture that achieves clever work distribution. It places
local view change updates on edge clouds for immediate responses, frame rendering on
edge clouds for high bandwidth, and global game state updates on the center cloud for
user scalability. In addition, they propose an efficient service placement algorithm based
on a Markov decision process. This algorithm dynamically places a user’s gaming service
on edge clouds while the user moves through different access points. It also co-places
multiple users to facilitate game world sharing and reduce the overall migration overhead.
Also, they derive optimal solutions and devise efficient heuristic approaches and study
different algorithm implementations to speed up the runtime.

-----------------------------------------------------------------------------------
[249] ✗

Lucas Chaufournier, Prateek Sharma, Franck Le, Erich Nahum, Prashant Shenoy,
and Don Towsley. **Fast transparent virtual machine migration in distributed edge
clouds.** In Proceedings of the Second ACM/IEEE Symposium on Edge Computing,
page 10. ACM, 2017.

It is suggested to use multi-path TCP for live migration of VMs across edge nodes to
improve VM migration time and network transparency of applications.

-----------------------------------------------------------------------------------
[253] ✗

Seyed Hossein Mortazavi, Bharath Balasubramanian, Eyal de Lara, and Shankaranarayanan
Puzhavakath Narayanan. **Toward session consistency for the edge.**
In USENIX Workshop on Hot Topics in Edge Computing (HotEdge 18), Boston, MA,
2018. USENIX Association.

It presents a novel storage system that provides session consistency even when the client
switches between replicas in different edge locations. Our client reconciliation algorithm
enforces session consistency at minimal costs, by tracking the accessed or affected keys
and reconciling them on the destination replica.

-----------------------------------------------------------------------------------
[254] ✗ ?

Roberto Bruschi, Franco Davoli, Paolo Lago, and Jane Frances Pajo. **Move with
me: Scalably keeping virtual objects close to users on the move.** In 2018 IEEE
International Conference on Communications (ICC), pages 1–6. IEEE, 2018.

It is proposed a VO clustering and migration policy that jointly considers user proximity
and inter-VO affinity to scalably support user mobility, while allowing service
differentiation among users.

-----------------------------------------------------------------------------------

[261] ✓ ?

Ya-Ju Yu, Te-Chuan Chiu, Ai-Chun Pang, Ming-Fan Chen, and Jiajia Liu. **Virtual
machine placement for backhaul traffic minimization in fog radio access networks.**
In Communications (ICC), 2017 IEEE International Conference on, pages
1–7. IEEE, 2017.

Analyzes the VM placement problem in fog radio access networks (F-RANs) with the
objective to minimize the overall back-haul traffic. The back-haul traffic is incurred
in two ways: the VM replication and data transmission to the cloud. When a user connects
to a fog node and requests an application service, there is no back-haul bandwidth
consumption if the fog node has the application VM. Otherwise, the VM has to be
replicated on the fog node, or the request is forwarded to the cloud. They formulate the
replica-based VM placement problem by considering the computing and storage of fog nodes,
the user service constraint, as well as the edge bandwidth constraint.

-----------------------------------------------------------------------------------

[270] ✓

Haolong Xiang, Xiaolong Xu, Haoquan Zheng, Shu Li, Taotao Wu, Wanchun
Dou, and Shui Yu. **An adaptive cloudlet placement method for mobile applications
over gps big data.** In Global Communications Conference (GLOBECOM),
2016 IEEE, pages 1–6. IEEE, 2016.

Introduces the concept of movable cloudlets and explores the problem of how to
cost-effectively deploy these movable cloudlets to enhance cloud services for
dynamic context-aware mobile applications. To this end, the authors propose an
adaptive cloudlet placement (via GPS) method for mobile applications.

-----------------------------------------------------------------------------------

[274] ✗

Tayebeh Bahreini and Daniel Grosu. **Efficient placement of multi-component
applications in edge computing systems.** In Proceedings of the Second ACM/IEEE
Symposium on Edge Computing, page 5. ACM, 2017.

The authors address the problem of multi-component application placement on fog nodes.
Each application could be modeled as a graph, where each node is a component of the
application, and the edges indicate the communication between them.

-----------------------------------------------------------------------------------

[277] ✗

Lin Wang, Lei Jiao, Ting He, Jun Li, and Max Mühlhäuser. **Service entity
placement for social virtual reality applications in edge computing.** In INFOCOM
2018-IEEE Conference on Computer Communications, IEEE, pages 1–9. IEEE, 2018.

Conduct the first formal study of the service entity placement problem for social VR
applications in edge computing.

-----------------------------------------------------------------------------------

[279] ✗

Nguyen B Truong, Gyu Myoung Lee, and Yacine Ghamri-Doudane. **Software
defined networking-based vehicular adhoc network with fog computing.** In
Integrated Network Management (IM), 2015 IFIP/IEEE International Symposium
on, pages 1202–1207. IEEE, 2015.

Vehicular ad hoc networks (VANETs) face many issues such as unreliable connectivity,
delay constraints, and poor scalability. The authors suggest that using principles of
fog computing along with SDN could solve many of the current problems with VANETs. In
their architecture, the vehicles, which act as end-users, are SDN wireless nodes. These
wireless nodes send their data to Road Side Units (RSUs) which are installed alongside
road systems. Once the data is sent to an RSU, it is then sent to an RSU controller
(RSUC) which is a cluster of RSUs connected by broadband. The RSUC is capable of data
storage and processing. Finally, the RSUCs communicate with the SDN controller, which
has global knowledge of the VANET system.

-----------------------------------------------------------------------------------

[284] ✗

Thomas Rausch, Stefan Nastic, and Schahram Dustdar. **Emma: Distributed qosaware
mqtt middleware for edge computing applications.** In Cloud Engineering
(IC2E), 2018 IEEE International Conference on, pages 191–197. IEEE, 2018.

Present EMMA, an edge-enabled publish–subscribe middleware that continuously monitors
network QoS and orchestrates a network of MQTT protocol brokers. It transparently
migrates MQTT clients to brokers in close proximity to optimize QoS. Experiments in a
real-world testbed show that EMMA can significantly reduce end-to-end latencies that
incur from network link usage, even in the face of client mobility and unpredictable
resource availability.

-----------------------------------------------------------------------------------

[285] ✓ ?

Yuanguo Bi, Guangjie Han, Chuan Lin, Qingxu Deng, Lei Guo, and Fuliang Li.
**Mobility support for fog computing: An sdn approach.** IEEE Communications
Magazine, 56(5):53–59, 2018.

Study of mobility support issue in fog computing for guaranteeing service continuity.
Propose a novel SDN enabled architecture that is able to facilitate mobility management
in fog computing by decoupling mobility management and data forwarding functions. Design
an efficient handover scheme by migrating mobility management and route optimization
logic to the SDN controller. By employing link layer information, the SDN controller can
pre-compute the optimal path by estimating the performance gain of each path.

-----------------------------------------------------------------------------------

[291] ✗

Luiz F Bittencourt, Javier Diaz-Montes, Rajkumar Buyya, Omer F Rana, and
Manish Parashar. **Mobility-aware application scheduling in fog computing.**
IEEE Cloud Computing, 4(2):26–35, 2017.

This paper discusses the problem of resource allocation considering the hierarchical
infrastructure composed of edge capacity and cloud data centers, analyzing application
classes along with different scheduling policies. To address this challenge, they
introduce a number of scheduling approaches that consider user mobility and edge
computing capacity, in the context of a Fog Computing infrastructure. Also, they discuss
the benefits of combining the application classes with scheduling policies in scenarios
that illustrate these scheduling approaches, especially in the context of user mobility.

-----------------------------------------------------------------------------------

[300] ✗ ?

Yuxuan Sun, Sheng Zhou, and Jie Xu. **Emm: Energy-aware mobility management
for mobile edge computing in ultra dense networks.** IEEE Journal on Selected
Areas in Communications, 35(11):2637–2646, 2017.

Develop a novel user-centric energy-aware mobility management (EMM) scheme, in order to
optimize the delay, under energy consumption constraint of the user. Based on Lyapunov
optimization and multi-armed bandit theories, EMM works in an online fashion. Theoretical
analysis explicitly takes radio handover and computation migration cost into consideration
and proves a bounded deviation on both the delay performance and energy consumption
compared with the oracle solution with exact and complete future system information. The
proposed algorithm also effectively handles the scenario in which candidate BSs randomly
switch ON/OFF during the offloading process of a task.

-----------------------------------------------------------------------------------

[322] ✗

Junguk Cho, Karthikeyan Sundaresan, Rajesh Mahindra, Jacobus Van der Merwe,
and Sampath Rangarajan. **Acacia: context-aware edge computing for continuous
interactive applications over mobile networks.** In Proceedings of the 12th International
on Conference on emerging Networking EXperiments and Technologies,
pages 375–389. ACM, 2016.

They propose ACACIA, a service abstraction framework that enables continuous interactive
(CI) applications on edge clouds in mobile networks. ACACIA uses context awareness and
employs LTE-direct for service discovery, which is a proximity service discovery technique
using D2D communication in IoT.

-----------------------------------------------------------------------------------

[325] ✗

Julien Gedeon, Christian Meurisch, Disha Bhat, Michael Stein, Lin Wang, and
Max Mühlhäuser. **Router-based brokering for surrogate discovery in edge
computing.** In Distributed Computing Systems Workshops (ICDCSW), 2017 IEEE
37th International Conference on, pages 145–150. IEEE, 2017.

This paper examines the problem of discovering surrogates, which are micro-clouds,
fog nodes, or cloudlets, used by client devices to offload computation tasks in a fog
computing environment. In order to enable the discovery and selection of available
surrogates, the authors propose a brokering mechanism in which available surrogates
advertise themselves to the broker. The broker receives client requests and considers
a number of attributes such as network information, hardware capabilities, and distance
to find the best available surrogate for the client. The proposed mechanism is
implemented on off-the-shelf home routers.

----------------------------------------------------------------------------------

[328]

Kazuya Okada, Shigeru Kashihara, Nao Kawanishi, Nobuo Suzuki, Keizo
Sugiyama, and Youki Kadobayashi. **Goedge: A scalable and stateless local
breakout method.** In Proceedings of the 2018 Workshop on Theory and Practice for
Integrated Cloud, Fog and Edge Computing Paradigms, pages 29–34. ACM, 2018.

??

----------------------------------------------------------------------------------

[354]

Bozhao Qi, Lei Kang, and Suman Banerjee. **A vehicle-based edge computing
platform for transit and human mobility analytics.** In Proceedings of the Second
ACM/IEEE Symposium on Edge Computing, page 1. ACM, 2017.

Introduz um sistema de monitorização e rastreamento em barramento baseado em Wi-Fi
que observa dispositivos móveis e fornece análises sobre pessoas dentro e fora do
veículo. O sistema pode usar ainda mais os dados obtidos pelo dispositivo sem fios
montado no veículo para rastrear movimentos de passageiros, detectar fluxos de
pedestres e avaliar como os fatores externos afetam a mobilidade humana, o que
fornece análises úteis aos operadores de trânsito.

----------------------------------------------------------------------------------

[365]

Yue Cao, Houbing Song, Omprakash Kaiwartya, Bingpeng Zhou, Yuan Zhuang,
Yang Cao, and Xu Zhang. **Mobile edge computing for big-data-enabled electric
vehicle charging.** IEEE Communications Magazine, 56(3):150–156, 2018.

??

----------------------------------------------------------------------------------

[379]

Zhuangdi Xu, Harshit Gupta, and Umakishore Ramachandran. **Sttr: A system
for tracking all vehicles all the time at the edge of the network.** In Proceedings of
the 12th ACM International Conference on Distributed and Event-based Systems,
pages 124–135. ACM, 2018.

??

----------------------------------------------------------------------------------

[381]

Dario Bruneo, Salvatore Distefano, Francesco Longo, Giovanni Merlino, Antonio
Puliafito, Valeria D’Amico, Marco Sapienza, and Giovanni Torrisi. **Stack4things
as a fog computing platform for smart city applications.** In Computer Communications
Workshops (INFOCOM WKSHPS), 2016 IEEE Conference on, pages
848–853. IEEE, 2016.

Apresenta o Stack4Things12, uma framework baseada no OpenStack IaaS middleware que
adota um modelo cloud-oriented para o "abastecimento" de recursos de IoT. A framework
deles permite a injeção de código em runtime através da cloud, que eles definem como
"contextualization".

----------------------------------------------------------------------------------

[385]

Márcio Moraes Lopes, Wilson A Higashino, Miriam AM Capretz, and Luiz Fernando
Bittencourt. **Myifogsim: A simulator for virtual machine migration in
fog computing.** In Companion Proceedings of the10th International Conference
on Utility and Cloud Computing, pages 47–52. ACM, 2017.

Uma extensão ao iFogSim para suportar mobilidade através da migração de VMs entre
cloudlets (MyiFogSim).

---------------------------------------------------------------------------------

[386]

Bastien Confais, Adrien Lebre, and Benoît Parrein. **An object store service for a
fog/edge computing infrastructure based on ipfs and a scale-out nas.** In Fog and
Edge Computing (ICFEC), 2017 IEEE 1st International Conference on, pages 41–50.
IEEE, 2017.

??

----------------------------------------------------------------------------------

[388]

Cagatay Sonmez, Atay Ozgovde, and Cem Ersoy. **Edgecloudsim: An environment
for performance evaluation of edge computing systems.** In Fog and Mobile Edge
Computing (FMEC), 2017 Second International Conference on, pages 39–44. IEEE,
2017.

Propõe outro ambiente de simulação de edge computing, EdgeCloudSim, que considera
recursos de rede e computacionais e abrange todos os aspectos da edge computing
simulation modeling, incluindo modelagem de rede e computacional. À semelhança do
iFogSim, o EdgeCloudSim também se baseia no CloudSim. Além disso, o EdgeCloudSim
fornece uma arquitetura modular para fornecer suporte para uma variedade de
funcionalidades críticas e suporta a simulação de cenários multi-tier em que
vários edge servers são executados em coordenados com soluções de cloud de
camada superior.

----------------------------------------------------------------------------------