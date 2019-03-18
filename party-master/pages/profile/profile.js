//index.js
//获取应用实例
var app = getApp()
Page({
  data: {
    motto: '预算、账户之类的',
    userInfo: {},
    list: [
      {
        id: 'count',
        name: '账户',
        open: false,
        //pages: ['view', 'scroll-view', 'swiper', 'movable-view', 'cover-view']
      }, {
        id: 'budget',
        name: '月预算',
        open: false,
        //pages: ['text', 'icon', 'progress', 'rich-text']
      }, {
        id: 'remind',
        name: '提醒记账',
        open: false,
        //pages: ['button', 'checkbox', 'form', 'input', 'label', 'picker', 'picker-view', 'radio', 'slider', 'switch', 'textarea']
      }
    ]
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
