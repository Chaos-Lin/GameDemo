import React from 'react';
import { Link } from 'react-router-dom';
import { FiHome, FiPlusCircle, FiUser } from 'react-icons/fi';

const BottomNav = () => {
  return (
    <nav className="bottom-nav">
      <Link to="/" className="nav-item">
        <FiHome className="nav-icon" />
      </Link>
      <Link to="/create" className="nav-item create-btn">
        <FiPlusCircle className="nav-icon" />
      </Link>
      <Link to="/profile" className="nav-item">
        <FiUser className="nav-icon" />
      </Link>
    </nav>
  );
};

export default BottomNav;