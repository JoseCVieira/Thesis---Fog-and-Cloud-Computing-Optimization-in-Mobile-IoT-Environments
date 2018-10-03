%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

1 - INTRODUÇÃO

As the data velocity and volume increases, moving the big data
from IoT devices to the cloud might not be efficient, or might be even
infeasible in some cases due to bandwidth constraints. On the other
hand, as time-sensitive and location-aware applications emerge
(such as patient monitoring, real-time manufacturing, self-driving
cars, flocks of drones, or cognitive assistance), the distant cloud
will not be able to satisfy the ultra-low latency requirements of
these applications, provide location-aware services, or scale to the
magnitude of the data that these applications produce [5]. Moreover,
in some applications, sending the data to the cloud may not be a
feasible solution due to privacy concerns.

List of conferences, journals, and magazines that publish state-of-the-art research papers on fog computing and its related edge computing paradigms: https://anrlutdallas.github.io/resource/projects/fog-computing-conferences.html

The data (categories and features/objectives of the papers) of this survey are available in the form of several datasets at 
https://github.com/ashkan-software/fog-survey-data

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

2 - CONCEITOS - ver figura 4, 6 e 7, tabela 2 e 3

- Cloud computing
O National Institute of Standards and Technology (NIST) define cloud computing como um modelo que promove o acesso omnipresente e on-demand network a recursos computacionais. Cloud data centers são grandes pools de recursos virtuais que são utilizados num pay-as-you-go cost model. Oferece IaaS, PaaS e SaaS (figura 2). Os recursos são disponibilizados e cobrados on-demand visto que é difícil de prever, sendo normalmente sobredimensionado ou subdimensionado (figura 3). 
Existem 4 tipos de clouds: private, community, public e hybrid. Cloud computing tem os problema de latência, largura de banda, privacidade e falta de dispersão geográfica. Para resolver estes problemas é introduzido o paradigma de fog computing.

- Fog computing - ver figura 5
Fog computing preenche a lacuna entre cloud e end devices (e.g., IoT nodes) permitindo processamento, armazenamento, rede e gestão de dados em nós de rede próximos. Os serviços mensionados são então realizados não só na cloud mas também pelos dispositivos desde o end device até à cloud, com preferência pelos nós mais próximos. Fog computing é definido pelo OpenFog Consortium [6] como "a horizontal system-level architecture that distributes computing, storage, control and networking functions closer to the users along a cloud-to-thing continuum". A natureza descentralizada de fog computing permite que um dispositivo atue como um fog node (server) ou use fog resources (cliente). Comparatiamente à cloud, fog computing oferece capacidade de processamento moderada e com baixos consumos. Clouds usam grandes datacenters. Fog utiliza pequenos servers, routers, switches, gateways, set-top boxes ou access points (AP). Fog ocupa menos espaço (menos hardware) e assim pode estar mais proximo dos end devices. É acedido através de dispositivos ligados desde a edge network até a network core. Cloud computing é apenas acedível apartir da network core. O acesso à internet continuo não é necessário para serviços fog-based, isto é, eles funcionam normalmente e mandam os updates para a cloud quando existe conexão. Cloud computing requer uma conexão continua quando o serviço está a correr. Tem vantagens em termos de energy, manufacturing, transportation, healthcare, smart cities, entre outros. Existem diferenças claras entre fog e cloud, no entanto, estes complementam-se e um não consegue substituir a necessidade do outro. Juntando os dois, os serviços que os dispositivos ligados utilizam são ainda mais otimizados. [fog RAN?? - paper 27]

- Mobile computing
O avanço em fog e cloud computing é influenciado pelo desenvlvimento de mobile computing. Mobile/nomadic computing acontece quando o processamento é feito por mobile devices (laptops, tablets, or mobile phones). Tem como objetivo a adaptação em ambientes de pouco poder de processamento e conexão esparça ou intermitente. Devido aos requisitos envolvidos de conexão de dispositivos do utilizador, mobile computing sozinho não é apropriado para computing. Com fog e cloud computing, a computação já não está limitada a uma rede local, expandindo assim o alcance de mobile computing. O único hardware necessário são os dispositivos móveis, que podem utilizar conexões via Bluetooth, WiFi, ZigBee etc. No caso de fog e cloud são necessários recursos de hardware mais avançados com capacidades de virtualização. A segurança em mobile computing é obrigatoriamente garantida no dispositivo móvel. Os dispositivos têm recursos mais restritos que em fog e cloud, no entanto nos últimos anos tem existido grande evolução neste sentido. Tem a grande vantagem da sua arquitetura distribuída visto que não é necessário uma localização central de operação. Tem as desvantagens de poucos recursos, balanceamento entre autonomia e interdependência (dependência de outros dispositivos móveis - que prevalece em todas as arquiteturas distribuídas), latência na comunicação e a necessidade de clientes móveis. Isto leva a que mobile computing seja inviável para aplicações atuais que requerem low-latency e robustez, ou que necessitem que grandes quantidades de dados sejam gerados, processados e armazenados.

- Mobile Cloud Computing
Cloud computing tornou-se um complemento valioso para mobile computing, onde esta combinação resultou em mobile cloud computing (MCC). MCC é definido como uma infra-estrutura onde o processamento e armazenamento ocorrem fora do dispositivo móvel. Aplicações móveis podem ser repartidas em runtime para que as partes computacionalmente mais intensas sejam tratadas por offloading adaptativo do dispositivo móvel para a cloud, diminuindo o consumo de bateria. Comparativamente a mobile computing, os serviços cloud-based em MCC são consideravelmente maiores. A computação pode também ser realizada no próprio dispositivo. Ao nível de segurança, deve ser implementada no dispositivo e na cloud. Desvantagens: Enquanto que uma arquitetura centralizada em MCC é melhor para partilha de pool de recursos computacionais, esta pode não ser adequado para aplicações onde os dispositivos são omnipresentes (pervasive). Como cloud computing e MCC requerem cloud-based services, e o seu acesso é feito pela rede core por WAN, as aplicações requerem ligação à internet todo o tempo. Offloading da computação para a cloud, causa latência relativamente alta para aplicações delay-sensitive.

- Mobile ad hoc Cloud Computing
Apesar da natureza difundida do MCC, este paradigma de computação nem sempre é adequado para cenários em que há falta de infra-estrutura ou de uma cloud centralizada. Uma rede móvel ad hoc consiste em nós que formam uma rede dinâmica e temporária por meio de protocolos de roteamento e transporte. Dispositivos móveis Ad hoc podem formar clouds que podem ser utilizadas para rede, armazenamento e computação. Inclui casos de uso como desastres naturais, streaming de vídeo ao vivo em grupo e sistemas de veículos não tripulados.

- Edge Computing
Tal como MCC, edge computing melhora a gestão, armazenamento e a capacidade de processamento dos dados gerados pelos dispositivos conectados. Ao contrário de MCC, edge computing está localizado na edge da rede, perto dos dispositivos IoT (edge não está localizado nos dispositivos IoT, mas está tão próximo como um hop para eles; se estiver na rede local pode estar a mais do que um hop). Edge computing é definida como a computação feita na edge da rede por pequenos data centers que estão próximos dos end users. Alguns problemas que a edge computing lida bem são a privacidade, latência (se tiver poder computacional suficiente; latência = latência envio + latência de processamento + latência de receção) e conectividade. Service availability é também maior porque não tem de esperar por uma plataforma centralizada para fornecer um serviço, nem são dispositivos conectados limitados por recursos limitados como mobile computing. EC e FG movem a computação e armazenamento para a edge da rede perto dos end users, no entanto estes paradigmas são bem distintos. Fog é hierárquico e fornece computação, rede, armazenamento, controlo e aceleração em qualquer lado desde a cloud aos end devices (things). Edge computing está limitado à computação na edge. Neste contexto, edge refere-se à rede local onde os dispositivos IoT estão. Podem ser utilizados, por exemplo, WiFi access points ou gateways. General Electric diz que fog computing se foca nas interações entre edge devices (e.g., RANs, base stations, or edge routers), enquanto edge computing se foca nas tecnologias ligadas as things (e.g., WiFi access points).

- Multi-access Edge Computing
Analogamente, mobile cloud computing é uma extensão de mobile computing por cloud computing e multi-access edge computing (MEC) é uma extensão de mobile computing através de edge computing. ETSI define que MAC é uma plataforma que fornece capacidades de IT e cloud-computing dentro de Access Network (RAN) em 4G e 5G, na proximidade dos mobile subscribers. MEC extende edge computing fornecendo computação e armazenamento aos dispositivos. MAC permite aos RAN operators adicionar funcionalidades de edge computing às base stations. Similarmente a edge computing, small-scale data centers com capacidades de virtualização podem ser usadas em MEC. Comparativamente a cloud computing, o hardware utilizado em MEC e edge computing é de nível moderado. Aplicações de low-latency podem ser suportadas em MEC. Estas podem benificiar de real-time radio e da informação de rede. Tal como edge computing, MEC pode operar com pouca ou nenhuma Internet. MEC utiliza WAN, WiFi, e cellular connections enquanto edge computing usa qualquer forma de ligação (e.g., LAN, WiFi, cellular). MCC foca-se na relação entre cloud service users (em mobile devices) e cloud service providers, enquanto MEC foca-se em (RAN-based) network infrastructure providers. MEC permite que edge computing seja acedível por um grande número de dispositivos móveis com latência reduzida e redes móveis core eficientes. MEC permiter aplicações críticas delay-sensitive sobre a rede móvel. Incorpora também a utilização de SDN que permite virtual networking devices para serem facilmente geridos por software APIs e network function virtualization (NFV) que permite tempos de implementação reduzidos para serviços de rede através de infra-estruturas virtualizadas.

- Cloudlet Computing
Cloudlet computing é outra direção na computação móvel que compartilha muitas características com MCC e MEC. Cloudlet é um computador ou cluster de computadores com forte ligação à internet que é utilizada por dispostitos móveis próximos. Cloudlets são pequenos data centers (miniature clouds), que está tipicamente a um hop de distância dos dispositivos móveis. A ideia é transferir a computação dos dispositivos móveis para VM-based cloudlets localizadas na edge. Cloudlet é a tier do meio numa arquitetura 3-tier: mobile-devicecloudlet-cloud. O pequeno footprint de hardware das cloudlets resulta em recursos computacionais moderados mas com baixa latência e baixo consumo energético comparado com cloud computing. Cloudlet necessita de uma infra-estrutura com virtualização em forma de virtual machine (VM), tem suporte para mobilidade e support para real-time IoT applications. Cloudlets suporta serviços locais para clientes móveis dividindo tasks pelos cloudlet nodes próximos do dispositivo móvel. Fog computing oferece uma alternativa mais genérica que nativamente suporta grandes quantidades de tráfego e permite que os recursos estejam em qualquer lado entre a cloud e as things. O conceito de mobile cloudlets é similar a cloudlets em que as cloudlets são um grupo de dispositivos móveis próximos que estão conectados sem fios (e.g., using WiFi or Bluetooth). Em mobile cloudlets, os dispositivos móveis podem ser tanto providers como clients de um serviço computacional.

- Mist Computing
Recentemente foi introduzido para capturar uma edge mais exterma - os endpoints - dos dispositivos conectados. Este paradigma descreve uma computação dispersa na extreme edge (os próprios dispositivos IoT) e foi proposto com futuros sistemas auto-conscientes e autónomos em mente. Pode ser visto como o primeiro ponto de computação na 3-tier IoT-fog-cloud. Mist computing extende computação, armazenamento e rede pelo fog através das things. Mist computing é um superset de MACC visto que em mist, a rede pode não ser necessariamente ad hoc e os dispositivos podem não ser móveis.

- Other Similar Computing Paradigms
	- Micro Data Center (MDC)
	Cloudlet são por vezes referidas como MDC. um MDC pode ser um edge node ou uma cloudlet que é implementada entre os dispositivos IoT e a cloud.

	- Cloud of Things (CoT)
	Parecido a mist computing, no entanto em mist a computação é feita nos dispositivos IoT e não necessariamente numa cloud de pooled resources. Em CoT, a computação é feira sobre a cloud que é formada por pooled resources de IoT devices.

	- Edge Cloud
	Quando falamos de cloud computing, falamos de "core" ou "distant" clouds que estão distantes do end users que são responsáveis pela computação "pesada". Ao contrário, "edge" clouds são mais pequenas e estão mais próximas. Edge cloud é parecido a edge computing. Edge cloud extende capacidades da cloud na edge aproveitando os compute nodes (user ou operator-contributed) na edge da rede. À semelhança do fog, em edge clouds a habilidade de correr uma aplicação numa forma coordenada tanto na edge com na distante cloud é previsto. Edge clouds são nós na edge como  micro data centers, cloudlets, e MEC.

- Offline vs. Online
A maioria dos papers fala de scheduling, dispatching, offloading, e load balancing de forma "centralizada" (referida como offline). Nesta configuração, toda a informação das tasks, rede e nós são conhecidas. A entidade centralizada é responsável por decidir para onde a task pode ser enviada. Mesmo que haja grande investigação nesta área, uma configuração mais desafiante é a versão "distribuída" do problema (referido como online) onde não existe uma entidade central, não existe informação total sobre tasks, rede ou sobre os nós. Neste caso, a informação de cada job é desconhecida antes do seu lançamento.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

3 - PAPERS - MOBILIDADE

✗ | ✓

-----------------------------------------------------------------------------------
[27]

Mugen Peng, Shi Yan, Kecheng Zhang, and Chonggang Wang. Fog-computingbased
radio access networks: issues and challenges. IEEE Network, 30(4):46–53, 2016.

Em C-RAN (cloud-radio access networks), um grande número de low-cost Remote Radio
Heads (RRHs) são implementados de forma random e ligados à pool Base Band Unit (BBU)
através dos links front-haul. Ambos F-RAN e C-RAN são adequados para redes móveis
com estações base e são candidatas para implantações 5G. Além disso, o uso de F-RAN
e C-RAN traz uma forma mais eficiente de operação de rede. Encorajamos o leitor
motivado a se referir à referência [27] para obter mais informações sobre o F-RAN.

-----------------------------------------------------------------------------------
[54]

Yong Cui, Jian Song, Kui Ren, Minming Li, Zongpeng Li, Qingmei Ren, and
Yangjun Zhang. Software defined cooperative offloading for mobile cloudlets.
IEEE/ACM Transactions on Networking, 25(3):1746–1760, 2017.


O conceito de cloudlets móveis é semelhante ao de cloudlets, no qual as cloudlets
são um grupo de dispositivos móveis próximos que estão ligados sem fios, por exemplo,
usando WiFi ou Bluetooth. Nas cloudlets móveis, os dispositivos móveis podem ser
fornecedores ou clientes de serviços de computação.

-----------------------------------------------------------------------------------
[97]

Marcelo Yannuzzi, R Milito, René Serral-Gracià, D Montero, and Mario Nemirovsky.
Key ingredients in an iot recipe: Fog computing, cloud computing,
and more fog computing. In Computer Aided Modeling and Design of Communication
Links and Networks (CAMAD), 2014 IEEE 19th International Workshop on,
pages 325–329. IEEE, 2014.

??

-----------------------------------------------------------------------------------
[112]

Ivan Farris, Roberto Girau, Leonardo Militano, Michele Nitti, Luigi Atzori, Antonio
Iera, and Giacomo Morabito. Social virtual objects in the edge cloud. IEEE
Cloud Computing, 2(6):20–28, 2015.

??

-----------------------------------------------------------------------------------
[116]

Yotam Harchol, Aisha Mushtaq, James McCauley, Aurojit Panda, and Scott
Shenker. Cessna: Resilient edge-computing. In Proceedings of the 2018 Workshop
on Mobile Edge Communications, pages 1–6. ACM, 2018.

Investigadores da UC Berkeley recentemente propuseram uma estrutura resiliente de
edge computing, que é um bom ponto de partida na direção de resilient fog
system design (apresentado com uma futura direção no fim do survey).

-----------------------------------------------------------------------------------
[123]

Sherif Abdelwahab, Sophia Zhang, Ashley Greenacre, Kai Ovesen, Kevin
Bergman, and Bechir Hamdaoui. When clones flock near the fog. IEEE Internet
of Things Journal, 2018.

??

-----------------------------------------------------------------------------------
[130]

Kai Liang, Liqiang Zhao, Xiaoli Chu, and Hsiao-Hwa Chen. An integrated
architecture for software defined and virtualized radio access networks with
fog computing. IEEE Network, 31(1):80–87, 2017.

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
[143]

Jianhua Li, Jiong Jin, Dong Yuan, and Hongke Zhang. Virtual fog: A virtualization
enabled fog computing framework for internet of things. IEEE Internet of
Things Journal, 5(1):121–131, 2018.

Este estudo junta fog computing e information-centric networking (ICN), que permite
uma distribuição de dados flexível e eficiente na camada de rede. Na arquitetura
ICN-Fog, na camada mais baixa estão os end devices heterogéneos que se ligam aos
fog nodes, que executam protocolos específicos da ICN para comunicar com outros fog
nodes. Além de se ligarem a outros fog nodes, cada fog nodes também está ligado à cloud.
Os autores mostram que ICN-Fog se baseia nos princípios do ICN para a construção de uma
comunicação inteligente de dados horizontal (fog-to-fog), que leva à redução da
dependência da aplicação sobre a cloud e ao processamento distribuído no fog.

-----------------------------------------------------------------------------------
[145]

Wenyu Zhang, Zhenjiang Zhang, and Han-Chieh Chao. Cooperative fog computing
for dealing with big data in the internet of vehicles: Architecture and
hierarchical resource management. IEEE Communications Magazine, 55(12):
60–67, 2017.

Introduz os desafios de lidar com big data nos ambientes de IoV. Os autores enfatizam
o papel dos fog servers e descrevem uma arquitetura CFC (cooperative fog computing)
para suportar aplicações IoV. A arquitetura CFC-IoV proposta consiste em duas camadas:
fog layer e edge layer. A camada de fog é uma federação de servidores geograficamente
distribuídos, um servidor coordenador e os cloud servers, enquanto a edge layer inclui
a vehicular ad hoc network (VANET), aplicações IoT e mobile cellular networks.
(Também é mencionado como trabalho futuro neste servey - redes IoV)

-----------------------------------------------------------------------------------
[146]

H. Zhang, Y. Qiu, X. Chu, K. Long, and V. C. M. Leung. Fog radio access networks:
Mobility management, interference mitigation, and resource optimization. IEEE
Wireless Communications, 24(6):120–127, Dec 2017.

Fala sobre mitigação de interferência, otimização de recursos e no gestão de mobilidade 
em F-RAN. Primeiro, apresenta a arquitetura do sistema que ilustra como os vários 
componentes em F-RAN, como macro RRHs (MRRHs), small RRHs (SRRHs), fog computing access 
points (F-APs) e smart user equipment (F-UE), trabalham em conjunto para o bom 
funcionamento do do F-RAN. Estes componentes conectam-se à BBU pool que suporta a 
otimização de recursos e fornece armazenamento e comunicações centralizadas em F-RAN.

-----------------------------------------------------------------------------------
[149]

Quan Yuan, Haibo Zhou, Jinglin Li, Zhihan Liu, Fangchun Yang, and
Xuemin Sherman Shen. Toward efficient content delivery for automated driving
services: An edge computing solution. IEEE Network, 32(1):80–86, 2018.

Discute a colocação de cache, onde é feita através do paradigma MEC em redes sem fio
para satisfazer as necessidades dos serviços de condução automatizados. Os requests 
enviados por veículos autónomos são primeiro processadas pelo edge server para determinar
se podem ser processados localmente ou precisam ser entregues à remote cloud.

-----------------------------------------------------------------------------------
[152]

Cesar A Garcia-Perez and Pedro Merino. Enabling low latency services on lte
networks. In Foundations and Applications of Self* Systems, IEEE International
Workshops on, pages 248–255. IEEE, 2016.

??

-----------------------------------------------------------------------------------
[160]

J. He, J. Wei, K. Chen, Z. Tang, Y. Zhou, and Y. Zhang. Multitier fog computing
with large-scale iot data analytics for smart cities. IEEE Internet of Things Journal,
5(2):677–686, April 2018.

Surge na secção Mobile Fog Computing no trabalha futuro apontado pelo servey. (A
maioria dos papers assume que os fog nodes são fixos e apenas consideram a mobilidade
dos dispositivos IoT). Um esforço inicial para fog nodes móveis pode ser encontrado
neste paper.

-----------------------------------------------------------------------------------
[172]

Xueshi Hou, Yong Li, Min Chen, DiWu, Depeng Jin, and Sheng Chen. Vehicular
fog computing: A viewpoint of vehicles as the infrastructures. IEEE Transactions
on Vehicular Technology, 65(6):3860–3873, 2016.

Surge na secção Support of High-speed Users no trabalha futuro apontado pelo servey.
Apresenta a ideia de vehicular fog computing (VFC) utilizando veículos com infraestrutura
de comunicação e computação. O VFC aproveita um grupo dinâmico de veículos para ajudar a
aumentar o poder computacional e diminuir os problemas de latência. De forma diferente da
vehicular cloud computing, o VFC suporta geodistribuição, tomada de decisão local e
real-time load-balancing. Além disso, o VFC depende da colaboração de veículos próximos,
em vez de depender dos servidores remotos, o que reduz os custos de implantação e o atraso.

-----------------------------------------------------------------------------------
[175]

I Farris, A Orsino, L Militano, Michele Nitti, Giuseppe Araniti, Luigi Atzori, and
Antonio Iera. Federations of connected things for delay-sensitive iot services in
5g environments. In Communications (ICC), 2017 IEEE International Conference
on, pages 1–6. IEEE, 2017.

Analisa os problemas de latência que podem ocorrer em aplicações IoT sensíveis a delay
devido às distâncias geográficas entre os dispositivos físicos IoT e os data centers.
Os autores consideram o paradigma mobile IoT federation as a service (MIFaaS) que
utiliza a pool de dispositivos geridos por fornecedores de cloud individuais como um
todo para ajudar a suportar aplicações sensíveis a delay. O modelo de rede considerado
é um ambiente de cellular IoT com várias LTE femtocells como os edge nodes da rede que
suportam o paradigma MIFaaS.

-----------------------------------------------------------------------------------
[177]

Ming Tao, Kaoru Ota, and Mianxiong Dong. Foud: integrating fog and cloud
for 5g-enabled v2g networks. IEEE Network, 31(2):8–13, 2017.

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
Falko Dressler. Vehicular micro clouds as virtual edge servers for efficient
data collection. In 23rd ACM International Conference on Mobile Computing
and Networking (MobiCom 2017), 2nd ACM International Workshop on Smart,
Autonomous, and Connected Vehicular Systems and Services (CarSys 2017), 2017.

Aborda o conceito de micro clouds de veículos baseado na informação do mapa. Vehicular
micro clouds são edge servers virtuais e são essencialmente clusters de carros que
ajudam a agregar e pré-processar dados que são transferidos para a cloud.

-----------------------------------------------------------------------------------
[185]

Paolo Bellavista, Stefano Chessa, Luca Foschini, Leo Gioia, and Michele Girolami.
Human-enabled edge computing: Exploiting the crowd as a dynamic extension
of mobile edge computing. IEEE Communications Magazine, 56(1):145–155, 2018.

Propõe a human-driven edge computing (HEC) como um novo modelo para estender a cobertura
de soluções tradicionais de MEC fixas, utilizando dispositivos que as pessoas carregam.

-----------------------------------------------------------------------------------
[186]

Seongah Jeong, Osvaldo Simeone, and Joonhyuk Kang. Mobile edge computing
via a uav-mounted cloudlet: Optimization of bit allocation and path planning.
IEEE Transactions on Vehicular Technology, 67(3):2049–2063, 2018.

Neste modelo, os UAVs atuam como fog nodes que fornecem recursos computacionais com
boa cobertura para IoT nodes.

-----------------------------------------------------------------------------------
[197]

Enrique Saurez, Kirak Hong, Dave Lillethun, Umakishore Ramachandran, and
Beate Ottenwälder. Incremental deployment and migration of geo-distributed
situation awareness applications in the fog. In Proceedings of the 10th ACM
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

Nam Ky Giang, Michael Blackstock, Rodger Lea, and Victor CM Leung. Developing
iot applications in the fog: a distributed dataflow approach. In Internet
of Things (IOT), 2015 5th International Conference on the, pages 155–162. IEEE,
2015.

??

-----------------------------------------------------------------------------------
[205]

Taeyeol Jeong, Jaeyoon Chung, James Won-Ki Hong, and Sangtae Ha. Towards
a distributed computing framework for fog. In Fog World Congress (FWC), 2017
IEEE, pages 1–6. IEEE, 2017.

Crystal fornece uma abstração para o desenvolvimento de aplicações fog distribuídas
e tolerante a falhas. Uma aplicação de fog utilizando o Crystal pode aproveitar ao
máximo a transparência da localização, self-healing, auto-scaling e suporte à mobilidade.

-----------------------------------------------------------------------------------
[210]

Qiang Fan and Nirwan Ansari. Cost aware cloudlet placement for big data processing
at the edge. In Communications (ICC), 2017 IEEE International Conference
on, pages 1–6. IEEE, 2017.

Aborda o problema de colocar os cloudlets para minimizar o custo de implantação dos
fornecedores e minimizar o end-to-end delay dos user requests. Como o custo total de
implantação de um fornecedor de cloudlet depende da localização dos cloudlets e da
quantidade de recursos, estes devem ter em consideração tanto o end-to-end delay e
o custo total de implementação.

-----------------------------------------------------------------------------------
[217]

Alberto Ceselli, Marco Premoli, and Stefano Secci. Mobile edge cloud network
design optimization. IEEE/ACM Transactions on Networking, 25(3):1818–1831,
2017.

??

-----------------------------------------------------------------------------------
[226]

Chanh Nguyen Le Tan, Cristian Klein, and Erik Elmroth. Location-aware load
prediction in edge data centers. In Fog and Mobile Edge Computing (FMEC), 2017
Second International Conference on, pages 25–31. IEEE, 2017.

É proposta uma location-aware load prediction para edge data centers. Para cada edge
datacenter, a carga é prevista usando o seu histórico de load time e os dos seus
datacenters vizinhos.

-----------------------------------------------------------------------------------
[231]

Rahul Urgaonkar, Shiqiang Wang, Ting He, Murtaza Zafer, Kevin Chan, and
Kin K Leung. Dynamic service migration and workload scheduling in edgeclouds.
Performance Evaluation, 91:205–228, 2015.

Aborda o problema de escalonamento e despacho de tasks em edge clouds.

-----------------------------------------------------------------------------------
[232]

Wuyang Zhang, Yi Hu, Yanyong Zhang, and Dipankar Raychaudhuri. Segue:
Quality of service aware edge cloud service migration. In Cloud Computing
Technology and Science (CloudCom), 2016 IEEE International Conference on, pages
344–351. IEEE, 2016.

Estuda o problema de migração de serviços em edge clouds, em resposta ao movimento do
utilizador e ao desempenho da rede. A solução baseia-se no Markov Decision Process (MDP),
que considera o estado da rede e o tempo de resposta do servidor na tomada de decisões
de migração.

-----------------------------------------------------------------------------------
[234]

Ivan Farris, Tarik Taleb, Miloud Bagaa, and Hannu Flick. Optimizing service
replication for mobile delay-sensitive applications in 5g edge network. In
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
Migcep: operator migration for mobility driven distributed complex
event processing. In Proceedings of the 7th ACM international conference on
Distributed event-based systems, pages 183–194. ACM, 2013.

??

-----------------------------------------------------------------------------------
[238]

Nam Ky Giang, Michael Blackstock, Rodger Lea, and Victor CM Leung. Developing
iot applications in the fog: a distributed dataflow approach. In Internet
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
Albert Y Zomaya. Follow me fog: Toward seamless handover timing schemes
in a fog computing environment. IEEE Communications Magazine, 55(11):72–78,
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

Lele Ma, Shanhe Yi, and Qun Li. Efficient service handoff across edge servers via
docker container migration. In Proceedings of the Second ACM/IEEE Symposium
on Edge Computing, page 11. ACM, 2017.

Igual ao [243] mas este utiliza Docker container migration entre edge nodes para
service handoff.

-----------------------------------------------------------------------------------
[246]

Xiang Sun and Nirwan Ansari. Primal: Profit maximization avatar placement
for mobile edge computing. In Communications (ICC), 2016 IEEE International
Conference on, pages 1–6. IEEE, 2016.

??

-----------------------------------------------------------------------------------
[247]

Wuyang Zhang, Jiachen Chen, Yanyong Zhang, and Dipankar Raychaudhuri.
Towards efficient edge cloud augmentation for virtual reality mmogs. In Proceedings
of the Second ACM/IEEE Symposium on Edge Computing, page 8. ACM,
2017.

??

-----------------------------------------------------------------------------------
[249]

Lucas Chaufournier, Prateek Sharma, Franck Le, Erich Nahum, Prashant Shenoy,
and Don Towsley. Fast transparent virtual machine migration in distributed edge
clouds. In Proceedings of the Second ACM/IEEE Symposium on Edge Computing,
page 10. ACM, 2017.

Sugere o uso de multi-path TCP para live migration de VMs entre edge nodes para
melhorar o tempo de migração da VM e a transparência de rede das aplicações.

-----------------------------------------------------------------------------------
[253]

Seyed Hossein Mortazavi, Bharath Balasubramanian, Eyal de Lara, and Shankaranarayanan
Puzhavakath Narayanan. Toward session consistency for the edge.
In USENIX Workshop on Hot Topics in Edge Computing (HotEdge 18), Boston, MA,
2018. USENIX Association.

??

-----------------------------------------------------------------------------------

[254]

Roberto Bruschi, Franco Davoli, Paolo Lago, and Jane Frances Pajo. Move with
me: Scalably keeping virtual objects close to users on the move. In 2018 IEEE
International Conference on Communications (ICC), pages 1–6. IEEE, 2018.

??

-----------------------------------------------------------------------------------

[261]

Ya-Ju Yu, Te-Chuan Chiu, Ai-Chun Pang, Ming-Fan Chen, and Jiajia Liu. Virtual
machine placement for backhaul traffic minimization in fog radio access networks.
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
Dou, and Shui Yu. An adaptive cloudlet placement method for mobile applications
over gps big data. In Global Communications Conference (GLOBECOM),
2016 IEEE, pages 1–6. IEEE, 2016.

Introduz o conceito de cloudlets móveis e explora o problema de como implantar de
forma econômica esses cloudlets móveis para otimizar os serviços de cloud para
aplicações móveis de dynamic context-aware. Para esse fim, os autores propõem um
método adaptável de colocação de cloudlet para aplicações móveis.

-----------------------------------------------------------------------------------

[274]

Tayebeh Bahreini and Daniel Grosu. Efficient placement of multi-component
applications in edge computing systems. In Proceedings of the Second ACM/IEEE
Symposium on Edge Computing, page 5. ACM, 2017.

Os autores abordam o problema do posicionamento de aplicações em vários componentes
(multi-component) em fog nodes. Cada aplicação poderia ser modelada como um gráfico,
onde cada nó é um componente da aplicação e as edges indicam a comunicação entre
eles.

-----------------------------------------------------------------------------------

[277]

Lin Wang, Lei Jiao, Ting He, Jun Li, and Max Mühlhäuser. Service entity
placement for social virtual reality applications in edge computing. In INFOCOM
2018-IEEE Conference on Computer Communications, IEEE, pages 1–9. IEEE, 2018.

??

-----------------------------------------------------------------------------------

[279]

Nguyen B Truong, Gyu Myoung Lee, and Yacine Ghamri-Doudane. Software
defined networking-based vehicular adhoc network with fog computing. In
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

Thomas Rausch, Stefan Nastic, and Schahram Dustdar. Emma: Distributed qosaware
mqtt middleware for edge computing applications. In Cloud Engineering
(IC2E), 2018 IEEE International Conference on, pages 191–197. IEEE, 2018.

??

-----------------------------------------------------------------------------------

[285]

Yuanguo Bi, Guangjie Han, Chuan Lin, Qingxu Deng, Lei Guo, and Fuliang Li.
Mobility support for fog computing: An sdn approach. IEEE Communications
Magazine, 56(5):53–59, 2018.

??

-----------------------------------------------------------------------------------

[291]

Luiz F Bittencourt, Javier Diaz-Montes, Rajkumar Buyya, Omer F Rana, and
Manish Parashar. Mobility-aware application scheduling in fog computing.
IEEE Cloud Computing, 4(2):26–35, 2017.

?? (apenas é referido na secção Mobile Fog Computing de trabalho futuro do servey
como exemplo de fog nodes fixos)

-----------------------------------------------------------------------------------

[300] Yuxuan Sun, Sheng Zhou, and Jie Xu. Emm: Energy-aware mobility management
for mobile edge computing in ultra dense networks. IEEE Journal on Selected
Areas in Communications, 35(11):2637–2646, 2017.

??

-----------------------------------------------------------------------------------

[322]

Junguk Cho, Karthikeyan Sundaresan, Rajesh Mahindra, Jacobus Van der Merwe,
and Sampath Rangarajan. Acacia: context-aware edge computing for continuous
interactive applications over mobile networks. In Proceedings of the 12th International
on Conference on emerging Networking EXperiments and Technologies,
pages 375–389. ACM, 2016.

ACACIA usa context awareness e implementa LTE-direct para descoberta de serviço, que
é uma técnica de descoberta de serviço de proximidade que usa comunicação D2D em IoT.

-----------------------------------------------------------------------------------

[325]

Julien Gedeon, Christian Meurisch, Disha Bhat, Michael Stein, Lin Wang, and
Max Mühlhäuser. Router-based brokering for surrogate discovery in edge
computing. In Distributed Computing Systems Workshops (ICDCSW), 2017 IEEE
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
Sugiyama, and Youki Kadobayashi. Goedge: A scalable and stateless local
breakout method. In Proceedings of the 2018 Workshop on Theory and Practice for
Integrated Cloud, Fog and Edge Computing Paradigms, pages 29–34. ACM, 2018.

??

----------------------------------------------------------------------------------

[354]

Bozhao Qi, Lei Kang, and Suman Banerjee. A vehicle-based edge computing
platform for transit and human mobility analytics. In Proceedings of the Second
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
Yang Cao, and Xu Zhang. Mobile edge computing for big-data-enabled electric
vehicle charging. IEEE Communications Magazine, 56(3):150–156, 2018.

??

----------------------------------------------------------------------------------

[379]

Zhuangdi Xu, Harshit Gupta, and Umakishore Ramachandran. Sttr: A system
for tracking all vehicles all the time at the edge of the network. In Proceedings of
the 12th ACM International Conference on Distributed and Event-based Systems,
pages 124–135. ACM, 2018.

??

----------------------------------------------------------------------------------

[381]

Dario Bruneo, Salvatore Distefano, Francesco Longo, Giovanni Merlino, Antonio
Puliafito, Valeria D’Amico, Marco Sapienza, and Giovanni Torrisi. Stack4things
as a fog computing platform for smart city applications. In Computer Communications
Workshops (INFOCOM WKSHPS), 2016 IEEE Conference on, pages
848–853. IEEE, 2016.

Apresenta o Stack4Things12, uma framework baseada no OpenStack IaaS middleware que
adota um modelo cloud-oriented para o "abastecimento" de recursos de IoT. A framework
deles permite a injeção de código em runtime através da cloud, que eles definem como
"contextualization".

----------------------------------------------------------------------------------

[385]

Márcio Moraes Lopes, Wilson A Higashino, Miriam AM Capretz, and Luiz Fernando
Bittencourt. Myifogsim: A simulator for virtual machine migration in
fog computing. In Companion Proceedings of the10th International Conference
on Utility and Cloud Computing, pages 47–52. ACM, 2017.

Uma extensão ao iFogSim para suportar mobilidade através da migração de VMs entre
cloudlets (MyiFogSim).

---------------------------------------------------------------------------------

[386]

Bastien Confais, Adrien Lebre, and Benoît Parrein. An object store service for a
fog/edge computing infrastructure based on ipfs and a scale-out nas. In Fog and
Edge Computing (ICFEC), 2017 IEEE 1st International Conference on, pages 41–50.
IEEE, 2017.

??

----------------------------------------------------------------------------------

[388]

Cagatay Sonmez, Atay Ozgovde, and Cem Ersoy. Edgecloudsim: An environment
for performance evaluation of edge computing systems. In Fog and Mobile Edge
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

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

3 - CHALLENGES AND FUTURE RESEARCH DIRECTIONS

| Challenge | Current Limitation | Research Direction or Potential Solution | Related Features or Objectives | Related Categories |
| --- | --- | --- | --- | --- |
| Fog service SLA | SLAs are not defined for fog systems. Current SLAs are defined for cloud services or network infrastructure. | • Define new and compatible SLA for fog systems. • Design SLA management techniques and framework for fog computing. • Support for multi-vendor or provider SLA for fog systems | QoS, Cost | Architectures and Frameworks for Fog; Control and Monitoring
| Multi-objective fog system design | Many schemes (e.g., offloading, load balancing) consider few objectives and ignore other objectives. | • Propose schemes that consider multiple objectives (e.g., latency, bandwidth, energy) simultaneously (e.g., an efficient task offloading scheme that considers bandwidth, waiting time, availability, security, and energy). | QoS, Cost, Energy, Bandwidth | Resource Analysis and Estimation; Scheduling, offloading, and Load Balancing; Testbeds and Experiments
| Bandwidth-aware fog system design | Few works consider bandwidth savings through the use of fog computing, even though one of the promising features of fog computing is to reduce bandwidth usage of the core. | • Need more studies on bandwidth savings through the use of fog computing. • Perform measurement studies to capture the actual bandwidth usage in the presence of fog. | Bandwidth | Testbeds and Experiments; Scheduling, offloading, and Load Balancing; Control and Monitoring; Resource Analysis and Estimation; Infrastructure Design
| Scalable design of fog schemes | Many of the existing schemes and algorithms for fog do not scale to the magnitude of IoT networks. | • Design scalable algorithms and schemes for fog systems, e.g., online task offloading scheme that does not consider individual IoT nodes for decision making • Verify scalability of the algorithm and schemes by actual implementation. | Scalability | Service Provisioning; Placement; Scheduling, offloading, and Load Balancing; Applications
| Mobile fog computing | Most of the existing literature assumes fog nodes are fixed, or focus on the mobility of IoT devices. If fog nodes are mobile, resource availability, offloading, and resources provisioning will be more challenging. | • Propose mobile fog computing, where fog nodes can move. • Scheme for management or federation of mobile fog nodes. • Provisioning method for mobile fog services to keep the service always-available for IoT nodes. • Design of mobility-aware task offloading and scheduling schemes when fog nodes are mobile. | Mobility, Management | Resource Discovery; Concepts and Frameworks using Fog; Programming Models and Data Modeling; Service Provisioning; Security and Privacy; Scheduling, offloading, and Load Balancing
| Fog resource monitoring | Few studies address monitoring of fog resources. Monitoring is more challenging if multiple operators use a fog node. | • Multi-operator fog resource monitoring techniques. • SDN-based monitoring software for resource monitoring and resource advertisement. | Management, programmability | Control and Monitoring; Software and Tools
| Green fog computing | Improving the overall energy consumption of fog has not been well studied (literature considered energy-aware computation offloading, energy-aware mobility management, and federation of IoT devices to improve energy consumption). | • Use of energy harvesters and battery storages for IoT devices and sensors. • Energy-aware fog node placement, e.g., close to renewable energy resources (solar, wind, or vibration) | Energy | Infrastructure Design; Resource Analysis and Estimation
| Support of high-speed users | Current communication protocols do not support high-speed users. | • Develop fast or stateless handshake protocols for high-speed users, e.g., users in vehicles or for automotive communication. • Develop machine-learning-based mobility prediction algorithms. | Mobility, RAS | Architectures and Frameworks for Fog; Service Provisioning; Resource Discovery
| Fog node security | Fog nodes normally are located close to users, e.g., at the base stations, routers, or even at extreme network edge such as WiFi access points. This makes their security challenging. | • Design of physically secure fog nodes against site attacks • Design secure hardware, safe against physical damage, jamming, etc. • Design strong access-control policies for fog nodes. | Security, Heterogeneity | Security and Privacy; Infrastructure Design; Hardware and Protocol Stack
| SDN support for fog | SDN does not have native support for fog computing. | • Enhancing and standardizing SDN (e.g., OpenFlow northbound, southbound, east-west bound interface) for fog use cases. | Foundation, programmability | Definition and Standards; Software and Tools
| Fog node site selection | Few studies address the fog node site selection problem, which is a design problem for finding appropriate locations for deploying for nodes. | • Developing fog node site selection strategies that considers communication, storage, and computing (a communication hotspot may not be a storage or computing hotspot). • Considering cost in fog node site selection strategies (e.g., deploying fog nodes in Manhattan may be a good decision concerning latency and bandwidth, but may not be a good decision with respect to rental costs). | Cost, RAS, QoS, Energy | Infrastructure Design; Resource Analysis and Estimation
| Resilient fog system design | Current fog networks do not consider failure or fault in the network. Also, denial of service (DoS) attacks are more possible on fog nodes, since they are more resource-constrained than cloud servers. | • Fault detection, fault prevention, and fault recovery in fog-based networks • DoS-resilient fog system design • Design a coordinated protection mechanism that considers fog and cloud to guarantee availability. | RAS, Security | Control and Monitoring; Infrastructure Design; Service Provisioning; Security and Privacy
| Fog federation | There is no fog federation framework or software similar to that of hybrid cloud federation schemes. | • Design new schemes for the federation of fog nodes, across different operating domains. • Design resource sharing models for fog nodes from different vendors/operators • Define new pricing models for federated fog resource sharing schemes | Management, programmability | Placement; Software and Tools; Resource Discovery. Service Provisioning
| Trust and authentication in heterogeneous fog systems | Heterogeneity of fog nodes and IoT nodes makes the conventional trust and authentication protocols unsuitable for fog systems. | • Design new authentication and trust mechanisms that could cope with heterogeneity of fog nodes and IoT nodes. • Design authentication protocols for fog nodes of different vendors/operators. | Heterogeneity, Security | Definition and Standards; Security and Privacy; Hardware and Protocol Stack
| Secure fog offloading | Offloading tasks to fog nodes might incur some security and privacy risks. | • Design secure and private offloading and load balancing schemes. • A mechanism for receivers to verify the correctness and integrity of the offloaded task. | Security, QoS | Scheduling, offloading, and Load Balancing; Security and Privacy
| PaaS for fog computing | Lack of a PaaS for fog systems, where developers can easily develop software across fog, IoT, and cloud. | • Developing a PaaS for fog computing, which is transparent to users and supports different communication- and application-level protocols and APIs. • Developing plugins for PaaS for different fog computing applications | Programmability, Management | Software and Tools; Service Provisioning; Programming Models and Data Modeling
| Standardizing fog computing | Many independent definitions for fog (and fog-related computing paradigms) are being proposed. | • Unanimous and universally-agreed on the definition of fog computing. | Foundation | Definition and Standards
| Hardware technologies for fog | Most studies do not use new available hardware or communication technologies. | • Use of new hardware and communication technologies, such as non-volatile storage technologies, optical networks, and FPGAs. | Scalability | Hardware and Protocol Stack