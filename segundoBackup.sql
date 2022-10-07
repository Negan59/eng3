PGDMP     %    /            	    z            ltda    14.4    14.4 &    3           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            4           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            5           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            6           1262    16394    ltda    DATABASE     d   CREATE DATABASE ltda WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE ltda;
                postgres    false            �            1259    16419 
   assinatura    TABLE     �   CREATE TABLE public.assinatura (
    ass_id integer NOT NULL,
    ass_nome text NOT NULL,
    ass_tipo text NOT NULL,
    ass_valor numeric NOT NULL,
    ass_status boolean NOT NULL
);
    DROP TABLE public.assinatura;
       public         heap    postgres    false            �            1259    16418    assinatura_ass_id_seq    SEQUENCE     �   CREATE SEQUENCE public.assinatura_ass_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.assinatura_ass_id_seq;
       public          postgres    false    214            7           0    0    assinatura_ass_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.assinatura_ass_id_seq OWNED BY public.assinatura.ass_id;
          public          postgres    false    213            �            1259    16462 	   pagamento    TABLE     �   CREATE TABLE public.pagamento (
    pag_id integer NOT NULL,
    pag_data date NOT NULL,
    pag_valor numeric NOT NULL,
    pag_usu integer NOT NULL,
    pag_ass integer,
    pag_prod integer
);
    DROP TABLE public.pagamento;
       public         heap    postgres    false            �            1259    16461    pagamento_pag_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pagamento_pag_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.pagamento_pag_id_seq;
       public          postgres    false    218            8           0    0    pagamento_pag_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.pagamento_pag_id_seq OWNED BY public.pagamento.pag_id;
          public          postgres    false    217            �            1259    16410    produto    TABLE     �  CREATE TABLE public.produto (
    prod_id integer NOT NULL,
    prod_titulo text NOT NULL,
    prod_ano integer NOT NULL,
    prod_desc text NOT NULL,
    prod_autor text NOT NULL,
    prod_tipo text NOT NULL,
    prod_valor numeric NOT NULL,
    prod_responsavel text NOT NULL,
    prod_status boolean NOT NULL,
    prod_url text NOT NULL,
    prod_foto text,
    prod_vendidos integer DEFAULT 0,
    prod_alugados integer DEFAULT 0
);
    DROP TABLE public.produto;
       public         heap    postgres    false            �            1259    16409    produto_prod_id_seq    SEQUENCE     �   CREATE SEQUENCE public.produto_prod_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.produto_prod_id_seq;
       public          postgres    false    212            9           0    0    produto_prod_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.produto_prod_id_seq OWNED BY public.produto.prod_id;
          public          postgres    false    211            �            1259    16429    produtoassinatura    TABLE     �   CREATE TABLE public.produtoassinatura (
    pa_ass_id integer NOT NULL,
    pa_prod_id integer NOT NULL,
    pa_data date NOT NULL
);
 %   DROP TABLE public.produtoassinatura;
       public         heap    postgres    false            �            1259    16486 	   transacao    TABLE     �   CREATE TABLE public.transacao (
    trans_id integer NOT NULL,
    trans_data date NOT NULL,
    trans_prodid integer NOT NULL,
    trans_usuid integer NOT NULL,
    trans_tipo integer NOT NULL,
    trans_dataexp date
);
    DROP TABLE public.transacao;
       public         heap    postgres    false            �            1259    16485    transacao_trans_id_seq    SEQUENCE     �   CREATE SEQUENCE public.transacao_trans_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.transacao_trans_id_seq;
       public          postgres    false    220            :           0    0    transacao_trans_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.transacao_trans_id_seq OWNED BY public.transacao.trans_id;
          public          postgres    false    219            �            1259    16399    usuario    TABLE     �   CREATE TABLE public.usuario (
    usu_id integer NOT NULL,
    usu_nome text NOT NULL,
    usu_email text NOT NULL,
    usu_senha text NOT NULL,
    usu_nivel integer NOT NULL,
    usu_status boolean NOT NULL,
    usu_url text
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    16398    usuario_usu_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_usu_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.usuario_usu_id_seq;
       public          postgres    false    210            ;           0    0    usuario_usu_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.usuario_usu_id_seq OWNED BY public.usuario.usu_id;
          public          postgres    false    209            �            1259    16444    usuarioassinatura    TABLE     �   CREATE TABLE public.usuarioassinatura (
    ua_ass_id integer NOT NULL,
    ua_usu_id integer NOT NULL,
    ua_data date NOT NULL
);
 %   DROP TABLE public.usuarioassinatura;
       public         heap    postgres    false            |           2604    16422    assinatura ass_id    DEFAULT     v   ALTER TABLE ONLY public.assinatura ALTER COLUMN ass_id SET DEFAULT nextval('public.assinatura_ass_id_seq'::regclass);
 @   ALTER TABLE public.assinatura ALTER COLUMN ass_id DROP DEFAULT;
       public          postgres    false    214    213    214            }           2604    16465    pagamento pag_id    DEFAULT     t   ALTER TABLE ONLY public.pagamento ALTER COLUMN pag_id SET DEFAULT nextval('public.pagamento_pag_id_seq'::regclass);
 ?   ALTER TABLE public.pagamento ALTER COLUMN pag_id DROP DEFAULT;
       public          postgres    false    217    218    218            y           2604    16413    produto prod_id    DEFAULT     r   ALTER TABLE ONLY public.produto ALTER COLUMN prod_id SET DEFAULT nextval('public.produto_prod_id_seq'::regclass);
 >   ALTER TABLE public.produto ALTER COLUMN prod_id DROP DEFAULT;
       public          postgres    false    211    212    212            ~           2604    16489    transacao trans_id    DEFAULT     x   ALTER TABLE ONLY public.transacao ALTER COLUMN trans_id SET DEFAULT nextval('public.transacao_trans_id_seq'::regclass);
 A   ALTER TABLE public.transacao ALTER COLUMN trans_id DROP DEFAULT;
       public          postgres    false    220    219    220            x           2604    16402    usuario usu_id    DEFAULT     p   ALTER TABLE ONLY public.usuario ALTER COLUMN usu_id SET DEFAULT nextval('public.usuario_usu_id_seq'::regclass);
 =   ALTER TABLE public.usuario ALTER COLUMN usu_id DROP DEFAULT;
       public          postgres    false    209    210    210            *          0    16419 
   assinatura 
   TABLE DATA           W   COPY public.assinatura (ass_id, ass_nome, ass_tipo, ass_valor, ass_status) FROM stdin;
    public          postgres    false    214   �*       .          0    16462 	   pagamento 
   TABLE DATA           \   COPY public.pagamento (pag_id, pag_data, pag_valor, pag_usu, pag_ass, pag_prod) FROM stdin;
    public          postgres    false    218   �*       (          0    16410    produto 
   TABLE DATA           �   COPY public.produto (prod_id, prod_titulo, prod_ano, prod_desc, prod_autor, prod_tipo, prod_valor, prod_responsavel, prod_status, prod_url, prod_foto, prod_vendidos, prod_alugados) FROM stdin;
    public          postgres    false    212   �*       +          0    16429    produtoassinatura 
   TABLE DATA           K   COPY public.produtoassinatura (pa_ass_id, pa_prod_id, pa_data) FROM stdin;
    public          postgres    false    215   c,       0          0    16486 	   transacao 
   TABLE DATA           o   COPY public.transacao (trans_id, trans_data, trans_prodid, trans_usuid, trans_tipo, trans_dataexp) FROM stdin;
    public          postgres    false    220   �,       &          0    16399    usuario 
   TABLE DATA           i   COPY public.usuario (usu_id, usu_nome, usu_email, usu_senha, usu_nivel, usu_status, usu_url) FROM stdin;
    public          postgres    false    210   �,       ,          0    16444    usuarioassinatura 
   TABLE DATA           J   COPY public.usuarioassinatura (ua_ass_id, ua_usu_id, ua_data) FROM stdin;
    public          postgres    false    216   *-       <           0    0    assinatura_ass_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.assinatura_ass_id_seq', 1, true);
          public          postgres    false    213            =           0    0    pagamento_pag_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.pagamento_pag_id_seq', 1, false);
          public          postgres    false    217            >           0    0    produto_prod_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.produto_prod_id_seq', 3, true);
          public          postgres    false    211            ?           0    0    transacao_trans_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.transacao_trans_id_seq', 1, false);
          public          postgres    false    219            @           0    0    usuario_usu_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.usuario_usu_id_seq', 3, true);
          public          postgres    false    209            *   &   x�3��K-I�ɬ�(J��,��45�3�,����� ��      .      x������ � �      (   �  x�M��j1��㧘0�v��)�Bmp�`z�e���jV;Ik7}��J}�}�ήk� ��i���5fq���8J(���ϱ�嵐�7����R�S&|�3$<xG�q��g2��S�(JX�O�x�M��QD���̑!){i	��O�*�%{dRh�8҇��hp�����^�#u�k2�0��np�c�NNtƊw|��!���O�m�(��T�mf���[���qE�	׷�5�	Û�Ei�����=�� �>�.}X,�ǣy�>�;6���H��:|L˟ͷzs�t���;�`g%d�Ǹ�����v��5F�V'��ZSZXQCϽ���NR��3���Vڲ��Ɩ�j�1�H�`룮��Zxb��\�����9����l6�)��      +      x�3�4�4202�54�50�r��1z\\\ d$t      0      x������ � �      &   k   x�3�t/���H-�MU�)MN,VHIU���,K�,J�L��9��&f��%��r����rp� d�
�ҹ�9��/�Wp�M�+M�Q�L��ϙ����E{X�3F��� �*.�      ,      x������ � �     