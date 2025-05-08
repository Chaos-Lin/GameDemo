import React from 'react';
import { Link } from 'react-router-dom';
import { FiHeart, FiTrendingUp, FiPackage, FiSearch } from 'react-icons/fi';
import './TopNav.css';

const TopNav = () => {
  return (
    <nav className="top-nav">
      <div className="nav-icons">
        <Link to="/" className="nav-item">
          <FiHeart className="nav-icon" />
          <span>关注</span>
        </Link>
        <Link to="/hot" className="nav-item">
          <FiTrendingUp className="nav-icon" />
          <span>热门</span>
        </Link>
        <Link to="/games" className="nav-item">
          <FiPackage className="nav-icon" />
          <span>游戏</span>
        </Link>
      </div>
      <div className="search-wrapper">
        <Link to="/search" className="search-icon">
          <FiSearch />
        </Link>
      </div>
    </nav>
  );
};

export default TopNav;