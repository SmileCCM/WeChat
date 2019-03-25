//logs.js
var util = require('../../utils/util.js')

const acount={
  zc:"支出",
  time:"",
  acount:"",
  sort:"一般",
  money:0,
  remark:""
}
Page({
  data: {
    date:"",
    end:"",
    logs: [],
    classes:['吃饭','服装','出行'],
    array:["未分类账户","支付宝","微信","现金"],
    index:0
  },
  onLoad: function () {
    const logs = wx.getStorageSync('logs') || [];
    var DATE = util.formatDateymd(new Date());
    this.setData({
      logs: logs.map(log => util.formatTime(new Date(log))),
      date: DATE,
      end: DATE
    });
  },

  formSubmit(e) {
    console.log('form发生了submit事件，携带数据为：', e.detail.value)
    const acount=e.detail.value
    console.log('form发生了submit事件，携带数据为const的acount：', acount)
    wx.showToast({
      title: '记账成功',
      icon: 'sussess',
      image: '',
      duration: 500,
      mask: true,
      success: function(res) {},
      fail: function(res) {},
      complete: function(res) {},
    })
  },

  bindDateChange(e) {
    this.setData({
      date: e.detail.value
    })
  },

  bindPickerChange(e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      index: e.detail.value
    })
  },
})
