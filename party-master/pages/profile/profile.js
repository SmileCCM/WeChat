//index.js
//获取应用实例
var app = getApp()
Page({
  data: {
    motto: '预算、账户之类的',
    userInfo: {}
  },
  //事件处理函数
  bindViewTap: function () {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    app.getUserInfo(userInfo => this.setData({ userInfo }))
  }
})
