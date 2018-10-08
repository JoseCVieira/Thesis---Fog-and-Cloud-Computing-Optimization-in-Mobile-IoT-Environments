**All One Needs to Know about Fog Computing and Related Edge Computing Paradigms: A Complete Survey**

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

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

??

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

Analisa os problemas de latência que podem ocorrer em aplicações IoT sensíveis a delay
devido às distâncias geográficas entre os dispositivos físicos IoT e os data centers.
Os autores consideram o paradigma mobile IoT federation as a service (MIFaaS) que
utiliza a pool de dispositivos geridos por fornecedores de cloud individuais como um
todo para ajudar a suportar aplicações sensíveis a delay. O modelo de rede considerado
é um ambiente de cellular IoT com várias LTE femtocells como os edge nodes da rede que
suportam o paradigma MIFaaS.

-----------------------------------------------------------------------------------
[177] ✗

Ming Tao, Kaoru Ota, and Mianxiong Dong. **Foud: integrating fog and cloud
for 5g-enabled v2g networks.** IEEE Network, 31(2):8–13, 2017.

Argumenta que a utilização de cloud e fog computing utilizando as atuais redes móveis
pode não ser totalmente adequada para fornecer os níveis desejados de QoS para a
movimentação de veículos elétricos em serviços V2G (vehicle-togrid). Propõem um modelo
de computação híbrida chamada "Foud", no qual a cloud e fog se juntam e são
disponibilizados para os sistemas V2G. No modelo proposto, a cloud permite a computação,
armazenamento e rede virtualizados estejam disponíveis para as entidades do sistema V2G,
enquanto o fog integra temporariamente os recursos de computação estacionários e móveis
localizados na edge das redes V2G para expandir a capacidade de computação.

-----------------------------------------------------------------------------------
[183]

Florian Hagenauer, Christoph Sommer, Takamasa Higuchi, Onur Altintas, and
Falko Dressler. **Vehicular micro clouds as virtual edge servers for efficient
data collection.** In 23rd ACM International Conference on Mobile Computing
and Networking (MobiCom 2017), 2nd ACM International Workshop on Smart,
Autonomous, and Connected Vehicular Systems and Services (CarSys 2017), 2017.

Aborda o conceito de micro clouds de veículos baseado na informação do mapa. Vehicular
micro clouds são edge servers virtuais e são essencialmente clusters de carros que
ajudam a agregar e pré-processar dados que são transferidos para a cloud.

-----------------------------------------------------------------------------------
[185]

Paolo Bellavista, Stefano Chessa, Luca Foschini, Leo Gioia, and Michele Girolami.
**Human-enabled edge computing: Exploiting the crowd as a dynamic extension
of mobile edge computing.** IEEE Communications Magazine, 56(1):145–155, 2018.

Propõe a human-driven edge computing (HEC) como um novo modelo para estender a cobertura
de soluções tradicionais de MEC fixas, utilizando dispositivos que as pessoas carregam.

-----------------------------------------------------------------------------------
[186]

Seongah Jeong, Osvaldo Simeone, and Joonhyuk Kang. **Mobile edge computing
via a uav-mounted cloudlet: Optimization of bit allocation and path planning.**
IEEE Transactions on Vehicular Technology, 67(3):2049–2063, 2018.

Neste modelo, os UAVs atuam como fog nodes que fornecem recursos computacionais com
boa cobertura para IoT nodes.

-----------------------------------------------------------------------------------
[197]

Enrique Saurez, Kirak Hong, Dave Lillethun, Umakishore Ramachandran, and
Beate Ottenwälder. **Incremental deployment and migration of geo-distributed
situation awareness applications in the fog.** In Proceedings of the 10th ACM
International Conference on Distributed and Event-based Systems, pages 258–269.
ACM, 2016.

Propõe o Foglets, um modelo de programação que facilita a programação distribuída nos
fog nodes. Foglets fornece APIs para abstração de dados espaço-temporais para armazenar
e retirar dados gerados por aplicações nos nós locais. Através da API do Foglets, os
processos são definidos para uma determinada região geoespacial e o Foglets gere os
componentes da aplicação nos Fog nodes. Foglets é implementado através da visualização
container-based. A API Foglets tem em consideração QoS e load balancing ao migrar dados
persistentes (com informações de estado) entre fog nodes.

-----------------------------------------------------------------------------------
[201]

Nam Ky Giang, Michael Blackstock, Rodger Lea, and Victor CM Leung. **Developing
iot applications in the fog: a distributed dataflow approach.** In Internet
of Things (IOT), 2015 5th International Conference on the, pages 155–162. IEEE,
2015.

??

-----------------------------------------------------------------------------------
[205]

Taeyeol Jeong, Jaeyoon Chung, James Won-Ki Hong, and Sangtae Ha. **Towards
a distributed computing framework for fog.** In Fog World Congress (FWC), 2017
IEEE, pages 1–6. IEEE, 2017.

Crystal fornece uma abstração para o desenvolvimento de aplicações fog distribuídas
e tolerante a falhas. Uma aplicação de fog utilizando o Crystal pode aproveitar ao
máximo a transparência da localização, self-healing, auto-scaling e suporte à mobilidade.

-----------------------------------------------------------------------------------
[210]

Qiang Fan and Nirwan Ansari. **Cost aware cloudlet placement for big data processing
at the edge.** In Communications (ICC), 2017 IEEE International Conference
on, pages 1–6. IEEE, 2017.

Aborda o problema de colocar os cloudlets para minimizar o custo de implantação dos
fornecedores e minimizar o end-to-end delay dos user requests. Como o custo total de
implantação de um fornecedor de cloudlet depende da localização dos cloudlets e da
quantidade de recursos, estes devem ter em consideração tanto o end-to-end delay e
o custo total de implementação.

-----------------------------------------------------------------------------------
[217]

Alberto Ceselli, Marco Premoli, and Stefano Secci. **Mobile edge cloud network
design optimization.** IEEE/ACM Transactions on Networking, 25(3):1818–1831,
2017.

??

-----------------------------------------------------------------------------------
[226]

Chanh Nguyen Le Tan, Cristian Klein, and Erik Elmroth. **Location-aware load
prediction in edge data centers.** In Fog and Mobile Edge Computing (FMEC), 2017
Second International Conference on, pages 25–31. IEEE, 2017.

É proposta uma location-aware load prediction para edge data centers. Para cada edge
datacenter, a carga é prevista usando o seu histórico de load time e os dos seus
datacenters vizinhos.

-----------------------------------------------------------------------------------
[231]

Rahul Urgaonkar, Shiqiang Wang, Ting He, Murtaza Zafer, Kevin Chan, and
Kin K Leung. **Dynamic service migration and workload scheduling in edgeclouds.**
Performance Evaluation, 91:205–228, 2015.

Aborda o problema de escalonamento e despacho de tasks em edge clouds.

-----------------------------------------------------------------------------------
[232]

Wuyang Zhang, Yi Hu, Yanyong Zhang, and Dipankar Raychaudhuri. **Segue:
Quality of service aware edge cloud service migration.** In Cloud Computing
Technology and Science (CloudCom), 2016 IEEE International Conference on, pages
344–351. IEEE, 2016.

Estuda o problema de migração de serviços em edge clouds, em resposta ao movimento do
utilizador e ao desempenho da rede. A solução baseia-se no Markov Decision Process (MDP),
que considera o estado da rede e o tempo de resposta do servidor na tomada de decisões
de migração.

-----------------------------------------------------------------------------------
[234]

Ivan Farris, Tarik Taleb, Miloud Bagaa, and Hannu Flick. **Optimizing service
replication for mobile delay-sensitive applications in 5g edge network.** In
Communications (ICC), 2017 IEEE International Conference on, pages 1–6. IEEE,
2017.

Define dois esquemas de otimização de Integer Linear Programming (ILP) para minimizar
a degradação de QoE (Quality of Experience) e o custo de implementação de réplicas em
serviços de replicação de serviço para MEC. Comparam os serviço de migração reativo e
proativo. O serviço de migração reativo depende do movimento do utilizador e adapta-se
a este, localizando o target edge mais adequado e depois começando o processo de
migração; no entanto, serviço de migração proativa implementa várias réplicas do serviço
do utilizador para nós vizinhos. Como uma direção futura, poder-se-ia estudar
path-oriented proactive migration e trade-offs entre a probabilidade de migração reativa
e o custo das replicações de serviços.

-----------------------------------------------------------------------------------
[237]

Beate Ottenwälder, Boris Koldehofe, Kurt Rothermel, and Umakishore Ramachandran.
**Migcep: operator migration for mobility driven distributed complex
event processing.** In Proceedings of the 7th ACM international conference on
Distributed event-based systems, pages 183–194. ACM, 2013.

??

-----------------------------------------------------------------------------------
[238]

Nam Ky Giang, Michael Blackstock, Rodger Lea, and Victor CM Leung. **Developing
iot applications in the fog: a distributed dataflow approach.** In Internet
of Things (IOT), 2015 5th International Conference on the, pages 155–162. IEEE,
2015.

Alguns estudos sugerem a virtualização dos serviços de rede para os edge devices.
Argumenta que o grande footprint das plataformas de virtualização é responsável por
impedi-los de serem utilizados na edge da rede. Apresenta o Glasgow Network Functions
(GNF), uma plataforma Network Functions Virtualization (NFV) container-based que executa
e orquestra VNFs leves. Ainda mostra que a framework apresentada possui baixo tempo de
instanciação de VNF e requisitos de memória, em comparação com outras tecnologias de
virtualização existentes, tornando-o adequado para ser utilizado numa variedade de edge
devices.

-----------------------------------------------------------------------------------
[243]

Wei Bao, Dong Yuan, Zhengjie Yang, Shen Wang, Wei Li, Bing Bing Zhou, and
Albert Y Zomaya. **Follow me fog: Toward seamless handover timing schemes
in a fog computing environment.** IEEE Communications Magazine, 55(11):72–78,
2017.

Observa que os mecanismos tradicionais de handover de rede móvel não conseguem lidar
com os pedidos de recursos de fog computation e os requisitos de low-latency das
aplicações IoT móveis. Os autores propõem a framework Follow Me Fog para garantir a
continuidade do serviço e reduzir a latência durante handovers. A ideia principal
proposta é monitorar continuamente a intensidade do sinal recebido dos fog nodes no
dispositivo IoT móvel e acionar a pré-migração de jobs de computação antes de
desconectar o dispositivo IoT do fog node existente.

-----------------------------------------------------------------------------------
[244]

Lele Ma, Shanhe Yi, and Qun Li. **Efficient service handoff across edge servers via
docker container migration.** In Proceedings of the Second ACM/IEEE Symposium
on Edge Computing, page 11. ACM, 2017.

Igual ao [243] mas este utiliza Docker container migration entre edge nodes para
service handoff.

-----------------------------------------------------------------------------------
[246]

Xiang Sun and Nirwan Ansari. **Primal: Profit maximization avatar placement
for mobile edge computing.** In Communications (ICC), 2016 IEEE International
Conference on, pages 1–6. IEEE, 2016.

??

-----------------------------------------------------------------------------------
[247]

Wuyang Zhang, Jiachen Chen, Yanyong Zhang, and Dipankar Raychaudhuri.
**Towards efficient edge cloud augmentation for virtual reality mmogs.** In Proceedings
of the Second ACM/IEEE Symposium on Edge Computing, page 8. ACM,
2017.

??

-----------------------------------------------------------------------------------
[249]

Lucas Chaufournier, Prateek Sharma, Franck Le, Erich Nahum, Prashant Shenoy,
and Don Towsley. **Fast transparent virtual machine migration in distributed edge
clouds.** In Proceedings of the Second ACM/IEEE Symposium on Edge Computing,
page 10. ACM, 2017.

Sugere o uso de multi-path TCP para live migration de VMs entre edge nodes para
melhorar o tempo de migração da VM e a transparência de rede das aplicações.

-----------------------------------------------------------------------------------
[253]

Seyed Hossein Mortazavi, Bharath Balasubramanian, Eyal de Lara, and Shankaranarayanan
Puzhavakath Narayanan. **Toward session consistency for the edge.**
In USENIX Workshop on Hot Topics in Edge Computing (HotEdge 18), Boston, MA,
2018. USENIX Association.

??

-----------------------------------------------------------------------------------

[254]

Roberto Bruschi, Franco Davoli, Paolo Lago, and Jane Frances Pajo. **Move with
me: Scalably keeping virtual objects close to users on the move.** In 2018 IEEE
International Conference on Communications (ICC), pages 1–6. IEEE, 2018.

??

-----------------------------------------------------------------------------------

[261]

Ya-Ju Yu, Te-Chuan Chiu, Ai-Chun Pang, Ming-Fan Chen, and Jiajia Liu. **Virtual
machine placement for backhaul traffic minimization in fog radio access networks.**
In Communications (ICC), 2017 IEEE International Conference on, pages
1–7. IEEE, 2017.

O artigo analisa o problema de colocação de VM em fog radio access networks (F-RANs)
com o objetivo de minimizar o back-haul traffic. O tráfego de backhaul é incorrido de
duas formas: a replicação de VM e a transmissão de dados para a cloud. Quando um
utilizador se liga a um fog node e solicita um serviço da aplicação, não há consumo
de largura de banda de retorno (back-haul) se o fog node tiver a VM da aplicação.
Caso contrário, a VM terá de ser replicada no fog node ou o request será encaminhado
para a cloud. O paper formula o problema de replica-based VM placement considerando a
computação e o armazenamento dos fog nodes, a restrição de serviço do utilizador, bem
como a restrição de largura de banda na edge.

-----------------------------------------------------------------------------------

[270]

Haolong Xiang, Xiaolong Xu, Haoquan Zheng, Shu Li, Taotao Wu, Wanchun
Dou, and Shui Yu. **An adaptive cloudlet placement method for mobile applications
over gps big data.** In Global Communications Conference (GLOBECOM),
2016 IEEE, pages 1–6. IEEE, 2016.

Introduz o conceito de cloudlets móveis e explora o problema de como implantar de
forma econômica esses cloudlets móveis para otimizar os serviços de cloud para
aplicações móveis de dynamic context-aware. Para esse fim, os autores propõem um
método adaptável de colocação de cloudlet para aplicações móveis.

-----------------------------------------------------------------------------------

[274]

Tayebeh Bahreini and Daniel Grosu. **Efficient placement of multi-component
applications in edge computing systems.** In Proceedings of the Second ACM/IEEE
Symposium on Edge Computing, page 5. ACM, 2017.

Os autores abordam o problema do posicionamento de aplicações em vários componentes
(multi-component) em fog nodes. Cada aplicação poderia ser modelada como um gráfico,
onde cada nó é um componente da aplicação e as edges indicam a comunicação entre
eles.

-----------------------------------------------------------------------------------

[277]

Lin Wang, Lei Jiao, Ting He, Jun Li, and Max Mühlhäuser. **Service entity
placement for social virtual reality applications in edge computing.** In INFOCOM
2018-IEEE Conference on Computer Communications, IEEE, pages 1–9. IEEE, 2018.

??

-----------------------------------------------------------------------------------

[279]

Nguyen B Truong, Gyu Myoung Lee, and Yacine Ghamri-Doudane. **Software
defined networking-based vehicular adhoc network with fog computing.** In
Integrated Network Management (IM), 2015 IFIP/IEEE International Symposium
on, pages 1202–1207. IEEE, 2015.

As Vehicular ad hoc networks (VANETs) enfrentam muitos problemas, como conectividade
não confiável, restrições de delay e baixa escalabilidade. O paper sugere que o uso
de princípios de fog computing juntamente com SDN poderia resolver muitos dos problemas
atuais com as VANETs. Na arquitetura apresentada, os veículos, que atuam como end-users,
são SDN wireless nodes. Esses nós enviam os seus dados para um Road Side Units (RSUs)
instalados ao longo dos sistemas rodoviários. Assim que os dados são enviados para o
RSU, eles são enviados para um controlador de RSU (RSUC), que é um cluster de RSUs
ligados por banda larga. O RSUC é capaz de armazenamento e processamento de dados.
Finalmente, os RSUCs comunicam com o controlador SDN, que tem conhecimento global
do sistema VANET.

-----------------------------------------------------------------------------------

[284]

Thomas Rausch, Stefan Nastic, and Schahram Dustdar. **Emma: Distributed qosaware
mqtt middleware for edge computing applications.** In Cloud Engineering
(IC2E), 2018 IEEE International Conference on, pages 191–197. IEEE, 2018.

??

-----------------------------------------------------------------------------------

[285]

Yuanguo Bi, Guangjie Han, Chuan Lin, Qingxu Deng, Lei Guo, and Fuliang Li.
**Mobility support for fog computing: An sdn approach.** IEEE Communications
Magazine, 56(5):53–59, 2018.

??

-----------------------------------------------------------------------------------

[291]

Luiz F Bittencourt, Javier Diaz-Montes, Rajkumar Buyya, Omer F Rana, and
Manish Parashar. **Mobility-aware application scheduling in fog computing.**
IEEE Cloud Computing, 4(2):26–35, 2017.

?? (apenas é referido na secção Mobile Fog Computing de trabalho futuro do servey
como exemplo de fog nodes fixos)

-----------------------------------------------------------------------------------

[300] Yuxuan Sun, Sheng Zhou, and Jie Xu. **Emm: Energy-aware mobility management
for mobile edge computing in ultra dense networks.** IEEE Journal on Selected
Areas in Communications, 35(11):2637–2646, 2017.

??

-----------------------------------------------------------------------------------

[322]

Junguk Cho, Karthikeyan Sundaresan, Rajesh Mahindra, Jacobus Van der Merwe,
and Sampath Rangarajan. **Acacia: context-aware edge computing for continuous
interactive applications over mobile networks.** In Proceedings of the 12th International
on Conference on emerging Networking EXperiments and Technologies,
pages 375–389. ACM, 2016.

ACACIA usa context awareness e implementa LTE-direct para descoberta de serviço, que
é uma técnica de descoberta de serviço de proximidade que usa comunicação D2D em IoT.

-----------------------------------------------------------------------------------

[325]

Julien Gedeon, Christian Meurisch, Disha Bhat, Michael Stein, Lin Wang, and
Max Mühlhäuser. **Router-based brokering for surrogate discovery in edge
computing.** In Distributed Computing Systems Workshops (ICDCSW), 2017 IEEE
37th International Conference on, pages 145–150. IEEE, 2017.

O artigo examina o problema de descobrir substitutos, que são micro-clouds, fog nodes
ou cloudlets, usados por dispositivos clientes para descarregar tasks de computação
num ambiente de fog computing. A fim de permitir a descoberta e seleção de substitutos
disponíveis, os autores propõem um brokering mechanism no qual os substitutos disponíveis
se anunciam a ao broker. O broker recebe requests de clientes e considera vários atributos,
como informações de rede, recursos de hardware e distância para encontrar o melhor
substituto disponível para o cliente. O mecanismo proposto é implementado nos routers
domésticos.

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