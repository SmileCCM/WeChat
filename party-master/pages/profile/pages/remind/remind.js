const templateMessageUrl = require('../../../../config.js').templateMessageUrl
var util = require('../../../../utils/util.js')
const app = getApp()
const formData = {
  keyword1: '懒主银，快回来记账',
  keyword2: '快速记账，记得每天都记账噢'
}
// pages/profile/pages/remind/remind.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    time: "",
    checked:false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var TIME =util.formatTimehm(new Date());
    this.setData({
      time: TIME
    });  

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  switchChange(e) {
    console.log('switch 发生 change 事件，携带值为', e.detail.value)
    const self = this
    const { formId } = e.detail
    const formData = e.detail.value
    this.setData({
      checked: e.detail.value
    })
    console.log('form_id is:', formId)

    app.getUserOpenId(function (err, openid) {
      if (!err) {
        wx.request({
          url: templateMessageUrl,
          method: 'POST',
          template_id:'xEwlrPZZF7BusQH5MEp1Z8ldL-T0Qr9qEyCIlZsujow',
          data: {
            form_id: formId,
            openid,
            formData
          },
          success(res) {
            console.log('submit form success', res)
            wx.showToast({
              title: '发送成功',
              icon: 'success'
            })
            self.setData({
              loading: false
            })
          },
          fail({ errMsg }) {
            console.log('submit form fail, errMsg is:', errMsg)
          }
        })
      } else {
        console.log('err:', err)
      }
    })
  },

  bindTimeChange(e) {
    this.setData({
      time: e.detail.value
    })
  }
})