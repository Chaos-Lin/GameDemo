import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import TopNav from './components/TopNav.js';
import NoteList from './components/NoteList.js';
import BottomNav from './components/BottomNav.js';
import './App.css';

function App() {
  return (
    <Router>
      <div className="app-container">
        {/* 顶部导航栏 */}
        <TopNav />
        
        {/* 主要内容区域 */}
        <div className="content-area">
          <Routes>
            <Route path="/" element={<NoteList type="follow" />} />
            <Route path="/hot" element={<NoteList type="hot" />} />
            <Route path="/games" element={<NoteList type="games" />} />
            <Route path="/search" element={<NoteList type="search" />} />
          </Routes>
        </div>

        {/* 底部导航栏 */}
        <BottomNav />
      </div>
    </Router>
  );
}

export default App;