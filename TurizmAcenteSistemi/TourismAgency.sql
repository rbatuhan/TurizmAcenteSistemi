PGDMP         "        	        |            TourismAgency    13.13    13.13 "    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16803    TourismAgency    DATABASE     l   CREATE DATABASE "TourismAgency" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE "TourismAgency";
                postgres    false            �            1259    16853    hotel    TABLE       CREATE TABLE public.hotel (
    hotel_id integer NOT NULL,
    hotel_name text NOT NULL,
    hotel_star text NOT NULL,
    hotel_city text NOT NULL,
    hotel_region text NOT NULL,
    hotel_address text NOT NULL,
    hotel_mail text NOT NULL,
    hotel_mpno text NOT NULL,
    hotel_features_carpark text NOT NULL,
    hotel_features_wifi text,
    hotel_features_pool text,
    hotel_features_fitness text,
    hotel_features_concierge text,
    hotel_features_spa text,
    hotel_features_room_service text
);
    DROP TABLE public.hotel;
       public         heap    postgres    false            �            1259    16851    hotel_hotel_id_seq    SEQUENCE     �   ALTER TABLE public.hotel ALTER COLUMN hotel_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.hotel_hotel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    203            �            1259    16863    pansion_type    TABLE     �   CREATE TABLE public.pansion_type (
    pansion_id integer NOT NULL,
    pansion_type text NOT NULL,
    hotel_id integer NOT NULL
);
     DROP TABLE public.pansion_type;
       public         heap    postgres    false            �            1259    16861    hoteltype_htype_id_seq    SEQUENCE     �   ALTER TABLE public.pansion_type ALTER COLUMN pansion_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.hoteltype_htype_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    205            �            1259    16904    reservation    TABLE     b  CREATE TABLE public.reservation (
    rsv_id integer NOT NULL,
    rsv_name text NOT NULL,
    rsv_mpno text NOT NULL,
    rsv_mail text NOT NULL,
    rsv_strt_date date NOT NULL,
    rsv_fnsh_date date NOT NULL,
    room_id integer NOT NULL,
    rsv_price integer NOT NULL,
    rsv_total_customer integer NOT NULL,
    rsv_customer_ssn text NOT NULL
);
    DROP TABLE public.reservation;
       public         heap    postgres    false            �            1259    16902    reservation_rsv_id_seq    SEQUENCE     �   ALTER TABLE public.reservation ALTER COLUMN rsv_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.reservation_rsv_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    209            �            1259    16934    room    TABLE       CREATE TABLE public.room (
    room_id integer NOT NULL,
    room_type text NOT NULL,
    room_stock integer NOT NULL,
    season_id integer NOT NULL,
    room_adult_prc integer NOT NULL,
    room_child_prc integer NOT NULL,
    hotel_id integer NOT NULL,
    pansion_id integer NOT NULL,
    room_square_meter integer NOT NULL,
    room_number_bed integer NOT NULL,
    room_tv text NOT NULL,
    room_minibar text NOT NULL,
    room_game_console text NOT NULL,
    room_kasa text NOT NULL,
    room_projection text NOT NULL
);
    DROP TABLE public.room;
       public         heap    postgres    false            �            1259    16932    room_room_id_seq1    SEQUENCE     �   ALTER TABLE public.room ALTER COLUMN room_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.room_room_id_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    211            �            1259    16894    season    TABLE     �   CREATE TABLE public.season (
    season_id integer NOT NULL,
    season_strt_date date NOT NULL,
    season_fnsh_date date NOT NULL,
    hotel_id integer NOT NULL
);
    DROP TABLE public.season;
       public         heap    postgres    false            �            1259    16892    season_season_id_seq    SEQUENCE     �   ALTER TABLE public.season ALTER COLUMN season_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.season_season_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    207            �            1259    16843    user    TABLE     �   CREATE TABLE public."user" (
    user_id integer NOT NULL,
    user_name text NOT NULL,
    user_password text NOT NULL,
    user_role text NOT NULL
);
    DROP TABLE public."user";
       public         heap    postgres    false            �            1259    16841    user_user_id_seq    SEQUENCE     �   ALTER TABLE public."user" ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    201            �          0    16853    hotel 
   TABLE DATA           '  COPY public.hotel (hotel_id, hotel_name, hotel_star, hotel_city, hotel_region, hotel_address, hotel_mail, hotel_mpno, hotel_features_carpark, hotel_features_wifi, hotel_features_pool, hotel_features_fitness, hotel_features_concierge, hotel_features_spa, hotel_features_room_service) FROM stdin;
    public          postgres    false    203   �)       �          0    16863    pansion_type 
   TABLE DATA           J   COPY public.pansion_type (pansion_id, pansion_type, hotel_id) FROM stdin;
    public          postgres    false    205   �+       �          0    16904    reservation 
   TABLE DATA           �   COPY public.reservation (rsv_id, rsv_name, rsv_mpno, rsv_mail, rsv_strt_date, rsv_fnsh_date, room_id, rsv_price, rsv_total_customer, rsv_customer_ssn) FROM stdin;
    public          postgres    false    209   �,       �          0    16934    room 
   TABLE DATA           �   COPY public.room (room_id, room_type, room_stock, season_id, room_adult_prc, room_child_prc, hotel_id, pansion_id, room_square_meter, room_number_bed, room_tv, room_minibar, room_game_console, room_kasa, room_projection) FROM stdin;
    public          postgres    false    211   C-       �          0    16894    season 
   TABLE DATA           Y   COPY public.season (season_id, season_strt_date, season_fnsh_date, hotel_id) FROM stdin;
    public          postgres    false    207   �.       �          0    16843    user 
   TABLE DATA           N   COPY public."user" (user_id, user_name, user_password, user_role) FROM stdin;
    public          postgres    false    201   M/       �           0    0    hotel_hotel_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hotel_hotel_id_seq', 31, true);
          public          postgres    false    202            �           0    0    hoteltype_htype_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.hoteltype_htype_id_seq', 42, true);
          public          postgres    false    204            �           0    0    reservation_rsv_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.reservation_rsv_id_seq', 44, true);
          public          postgres    false    208            �           0    0    room_room_id_seq1    SEQUENCE SET     @   SELECT pg_catalog.setval('public.room_room_id_seq1', 28, true);
          public          postgres    false    210            �           0    0    season_season_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.season_season_id_seq', 49, true);
          public          postgres    false    206            �           0    0    user_user_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.user_user_id_seq', 60, true);
          public          postgres    false    200            I           2606    16860    hotel hotel_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT hotel_pkey PRIMARY KEY (hotel_id);
 :   ALTER TABLE ONLY public.hotel DROP CONSTRAINT hotel_pkey;
       public            postgres    false    203            K           2606    16870    pansion_type hoteltype_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.pansion_type
    ADD CONSTRAINT hoteltype_pkey PRIMARY KEY (pansion_id);
 E   ALTER TABLE ONLY public.pansion_type DROP CONSTRAINT hoteltype_pkey;
       public            postgres    false    205            O           2606    16911    reservation reservation_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (rsv_id);
 F   ALTER TABLE ONLY public.reservation DROP CONSTRAINT reservation_pkey;
       public            postgres    false    209            Q           2606    16942    room room_pkey1 
   CONSTRAINT     R   ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey1 PRIMARY KEY (room_id);
 9   ALTER TABLE ONLY public.room DROP CONSTRAINT room_pkey1;
       public            postgres    false    211            M           2606    16901    season season_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.season
    ADD CONSTRAINT season_pkey PRIMARY KEY (season_id);
 <   ALTER TABLE ONLY public.season DROP CONSTRAINT season_pkey;
       public            postgres    false    207            G           2606    16850    user user_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_pkey;
       public            postgres    false    201            �   
  x��Sˎ�0]�|�׳@y8@��AmEi�VSus!�`�I��?�Ϙ_�lf�.��&�)Am�8O�s��=q�a(�,M؍�{�����5�G�gp��)Tl�a(2�ާ��k�����eag���9��ؼ���i0��݇qs��-ׅ�Z��Z��MQGkC[|ϣ\c�Dc��J�#6�5*U
p8�:�/��iC@m-�߷i4Z�0-׃[�����jØ,s�L$Fl��TxxڱiJ��
��߆�X{��^����0R��9�*$/0	k��H�Q񼅷I�{67�YS򓍢��/k[
������ލJ�Ci�*�f��90��(�Rӻ�4n��R�c]���5�d86�j����{4Z8�M���P�˓��`Pmޕq(:��|�-r-w1������rr���=~��">#�P�̆��0�Z&[T�]��2ʸu*�9 U�iŞ���"�Mx��7��QFe`S���t}��ExϮ�oi�%���O������N� �cY�O?^      �   �   x�}��
�PF�w�b� t���"��"h3�ś�Y�˴m�3T�t���3�V{�Ԃ���}3-.$˭"�S;9�F�s�Ve�j8G@��ۢ�K�?︼X�ImҼ�q8�0P�֩�J������f���5�;��0���&1x�F
E0�u�XE؛�w�� #��� �3��v�#v@Ӹ�]8� ��;��      �   n   x�u�1
�@k�/gV�[%e>�Ҙ� Ƙ�0y�qk�b��i�q��e�`�n��������Yp)�C��(Ic@�?c]�ɽ�׾�����C�!�pd˅���1��q�"�      �   k  x�uRKJ�@]��bN ]]՟,�:AE܎Fd��È����I�؁�^�O=bܜ߆����y8�`v������2���wGR��ᣢI�ᓝqF=��/ώ��~��^�#(��2^J�@g��
�3��g��D����� Q�-�����rZ���3���y�@f&6��J9�*U(��KQU�uk�Uj�&��F4ש�I��#������H5:�I�6�W�5oQ��8�
�6��3-�l�,�J��<y^�ZMU��!2rG7��Y�P��ꮐ����ƪE���#�z��mV���I�ס+�7�T2#���]��J��S�s���zӢW#5�%h�5ٹ�˼t���)0�Mo����W��E      �      x�u�Q
�0C���tĖ�w���Qo�͠�a�����ckVo�}c���f��7�ׯ��1������G0���P� w�+v<|�uD{�\̔/�|Ũ|�W��/�X���v�]06������	Y|Vf      �   B   x�3�LL���C&��8R����Rs��܂����T.S��T0��s���D��gb"��1z\\\ ��8     