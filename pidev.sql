-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 29 mars 2020 à 06:20
-- Version du serveur :  5.7.24
-- Version de PHP :  7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pidev`
--

-- --------------------------------------------------------

--
-- Structure de la table `blog`
--

DROP TABLE IF EXISTS `blog`;
CREATE TABLE IF NOT EXISTS `blog` (
  `idb` int(11) NOT NULL AUTO_INCREMENT,
  `sujet` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `idcommande` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `idlivre` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcommande`),
  KEY `fk_livre` (`idlivre`),
  KEY `fk_usercommande` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `idc` int(11) NOT NULL AUTO_INCREMENT,
  `descriptionc` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `typec` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datec` date NOT NULL,
  `idPublication` int(11) NOT NULL,
  `idUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`idc`),
  KEY `fk_pub` (`idPublication`),
  KEY `fk_user1` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `concours`
--

DROP TABLE IF EXISTS `concours`;
CREATE TABLE IF NOT EXISTS `concours` (
  `idcn` int(11) NOT NULL AUTO_INCREMENT,
  `test` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datecn` date NOT NULL,
  `section` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcn`),
  KEY `fk_user5` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

DROP TABLE IF EXISTS `contact`;
CREATE TABLE IF NOT EXISTS `contact` (
  `idcontact` int(11) NOT NULL AUTO_INCREMENT,
  `email_i` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sujet` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idcontact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titreCours` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `matiere` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `duree` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idEnseignant` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_B26681E353314B` (`idEnseignant`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id`, `date`, `description`, `idEnseignant`) VALUES
(1, '2020-04-01 00:02:00', 'La jeune Alicia Keys fait sensation lors de la soirée', 1),
(2, '2015-01-01 00:00:00', 'Artistes, inventeurs, créations... souvenez-vous', 1),
(3, '2019-01-01 00:00:00', 'Lancement du premier simple du groupe Pink Floyd', 1),
(4, '2015-03-01 00:02:00', 'Sortie du film bienvenue chez les ch\'tis', 1);

-- --------------------------------------------------------

--
-- Structure de la table `exam`
--

DROP TABLE IF EXISTS `exam`;
CREATE TABLE IF NOT EXISTS `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `matiere` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `duree` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `exam_cours`
--

DROP TABLE IF EXISTS `exam_cours`;
CREATE TABLE IF NOT EXISTS `exam_cours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cours` int(11) DEFAULT NULL,
  `exam` int(11) DEFAULT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_AF2F8A2CFDCA8C9C` (`cours`),
  KEY `IDX_AF2F8A2C38BBA6C6` (`exam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

DROP TABLE IF EXISTS `formation`;
CREATE TABLE IF NOT EXISTS `formation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomFormation` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `duree` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prix` double NOT NULL,
  `coursId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_404021BF1347B425` (`coursId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `formations_offre`
--

DROP TABLE IF EXISTS `formations_offre`;
CREATE TABLE IF NOT EXISTS `formations_offre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idFormation` int(11) DEFAULT NULL,
  `idOffre` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_DBA3736BCAA0AE9` (`idFormation`),
  KEY `IDX_DBA3736B842C572` (`idOffre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `fos_user`
--

DROP TABLE IF EXISTS `fos_user`;
CREATE TABLE IF NOT EXISTS `fos_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `confirmation_token` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  `nom` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `datenaissance` date DEFAULT NULL,
  `section` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `circuit` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diplome` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `formation` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nbrheure` int(11) DEFAULT NULL,
  `specialite` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `frais` double DEFAULT NULL,
  `salaire` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_957A647992FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_957A6479A0D96FBF` (`email_canonical`),
  UNIQUE KEY `UNIQ_957A6479C05FB297` (`confirmation_token`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `fos_user`
--

INSERT INTO `fos_user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `nom`, `prenom`, `datenaissance`, `section`, `circuit`, `diplome`, `formation`, `nbrheure`, `specialite`, `frais`, `salaire`) VALUES
(1, 'ferouk', 'ferouk', 'farouk@esprit.tn', 'farouk@esprit.tn', 1, NULL, '$2y$13$k5LRhBF/vgL1KG45z3cpyObbX0Yr8LIbzPXWccMsBdFLwJXjRuKWS', '2020-03-14 08:47:36', NULL, NULL, 'a:2:{i:0;s:10:\"ROLE_ADMIN\";i:1;s:16:\"ROLE_SUPER_ADMIN\";}', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `livraison`
--

DROP TABLE IF EXISTS `livraison`;
CREATE TABLE IF NOT EXISTS `livraison` (
  `idlivraison` int(11) NOT NULL AUTO_INCREMENT,
  `idcommande` int(11) DEFAULT NULL,
  `adresse` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idlivraison`),
  KEY `fk_commande` (`idcommande`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

DROP TABLE IF EXISTS `livre`;
CREATE TABLE IF NOT EXISTS `livre` (
  `idlivre` int(11) NOT NULL AUTO_INCREMENT,
  `nomlivre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `auteurlivre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datelivre` date NOT NULL,
  `prixlivre` double NOT NULL,
  `contenu` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idlivre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `offre`
--

DROP TABLE IF EXISTS `offre`;
CREATE TABLE IF NOT EXISTS `offre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prix` double NOT NULL,
  `dateDebut` datetime NOT NULL,
  `dateFin` datetime NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `photo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `offre`
--

INSERT INTO `offre` (`id`, `prix`, `dateDebut`, `dateFin`, `description`, `photo`) VALUES
(19, 500, '2020-01-01 00:00:00', '2023-01-01 00:00:00', 'Java et html', '90fdd30b327b05fb584995a512299ebb.jpeg'),
(20, 600, '2015-01-01 00:00:00', '2015-02-01 00:00:00', 'php , css , html', '58eb703d9fcb3f9fc5c182e02e540b33.jpeg'),
(21, 600, '2019-01-03 00:00:00', '2015-03-03 00:00:00', 'symfony , javascript', '759829cdae7a079f498a9cfaf2b3ca05.jpeg'),
(22, 800, '2020-09-10 00:00:00', '2015-12-01 00:00:00', 'web (java, symfony , html,css)', '4e281e97d083e2999eaecdd47e947dd1.jpeg'),
(23, 100, '2015-01-18 00:00:00', '2015-02-03 00:00:00', 'css', '844f1cfb07ccaebfc4993ba55232078a.jpeg');

-- --------------------------------------------------------

--
-- Structure de la table `publication`
--

DROP TABLE IF EXISTS `publication`;
CREATE TABLE IF NOT EXISTS `publication` (
  `idp` int(11) NOT NULL AUTO_INCREMENT,
  `descriptionp` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `typep` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datep` date NOT NULL,
  `idUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`idp`),
  KEY `fk_user` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `idr` int(11) NOT NULL AUTO_INCREMENT,
  `nomr` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sujetr` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `dater` date NOT NULL,
  `idUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`idr`),
  KEY `fk_user3` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `idatt` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date` date NOT NULL,
  `idUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`idatt`),
  KEY `fk_user4` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `student_exam`
--

DROP TABLE IF EXISTS `student_exam`;
CREATE TABLE IF NOT EXISTS `student_exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student` int(11) DEFAULT NULL,
  `exam` int(11) DEFAULT NULL,
  `note` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_798DD1EB723AF33` (`student`),
  KEY `IDX_798DD1E38BBA6C6` (`exam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `FK_6EEAA67D6B3CA4B` FOREIGN KEY (`id_user`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_6EEAA67D7A662380` FOREIGN KEY (`idlivre`) REFERENCES `livre` (`idlivre`);

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `FK_67F068BCFE6E88D7` FOREIGN KEY (`idUser`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `concours`
--
ALTER TABLE `concours`
  ADD CONSTRAINT `FK_4FAE5196FE6E88D7` FOREIGN KEY (`idUser`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `FK_B26681E353314B` FOREIGN KEY (`idEnseignant`) REFERENCES `fos_user` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `exam_cours`
--
ALTER TABLE `exam_cours`
  ADD CONSTRAINT `FK_AF2F8A2C38BBA6C6` FOREIGN KEY (`exam`) REFERENCES `exam` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_AF2F8A2CFDCA8C9C` FOREIGN KEY (`cours`) REFERENCES `cours` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `FK_404021BF1347B425` FOREIGN KEY (`coursId`) REFERENCES `cours` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `formations_offre`
--
ALTER TABLE `formations_offre`
  ADD CONSTRAINT `FK_DBA3736B842C572` FOREIGN KEY (`idOffre`) REFERENCES `offre` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_DBA3736BCAA0AE9` FOREIGN KEY (`idFormation`) REFERENCES `formation` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `livraison`
--
ALTER TABLE `livraison`
  ADD CONSTRAINT `FK_A60C9F1FC43FEE70` FOREIGN KEY (`idcommande`) REFERENCES `commande` (`idcommande`);

--
-- Contraintes pour la table `publication`
--
ALTER TABLE `publication`
  ADD CONSTRAINT `FK_AF3C6779FE6E88D7` FOREIGN KEY (`idUser`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `FK_CE606404FE6E88D7` FOREIGN KEY (`idUser`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `FK_E19D9AD2FE6E88D7` FOREIGN KEY (`idUser`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `student_exam`
--
ALTER TABLE `student_exam`
  ADD CONSTRAINT `FK_798DD1E38BBA6C6` FOREIGN KEY (`exam`) REFERENCES `fos_user` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_798DD1EB723AF33` FOREIGN KEY (`student`) REFERENCES `fos_user` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
